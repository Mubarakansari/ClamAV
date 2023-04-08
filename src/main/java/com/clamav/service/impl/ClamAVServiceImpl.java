package com.clamav.service.impl;

import com.clamav.dto.GenericResponse;
import com.clamav.service.ClamAVService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import xyz.capybara.clamav.ClamavClient;
import xyz.capybara.clamav.commands.scan.result.ScanResult;

import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.util.Collection;
import java.util.Map;

@Service
public class ClamAVServiceImpl implements ClamAVService {

    @Override
    public GenericResponse uploadFile(MultipartFile files) {
        ClamavClient client = new ClamavClient("127.0.0.1", 3310);
        GenericResponse genericResponse = null;
//        System.out.println("stats>>" + client.scan(Paths.get("/home/mubarak/Downloads/xampp-linux-x64-8.0.11-2-installer.run")));
        try {
            ScanResult scanResult = client.scan(files.getInputStream());
            if (scanResult instanceof ScanResult.OK) {
                System.out.println("==============Virus not found============");
                genericResponse = new GenericResponse(files.getOriginalFilename(), readableFileSize(files.getSize()), false, null);
            } else if (scanResult instanceof ScanResult.VirusFound) {
                Map<String, Collection<String>> viruses = ((ScanResult.VirusFound) scanResult).getFoundViruses();
                System.out.println("==============Virus found============" + viruses);
                genericResponse = new GenericResponse(files.getOriginalFilename(), readableFileSize(files.getSize()), true, viruses);
            }
        } catch (Exception e) {
            genericResponse = new GenericResponse(files.getOriginalFilename(), readableFileSize(files.getSize()), false, null, e.getMessage());
            System.out.println("Error Response>>" + e.getMessage());
            e.printStackTrace();
        }
        return genericResponse;
    }

    public static String readableFileSize(long size) {
        if (size <= 0) {
            return "0";
        }
        final String[] units = new String[]{"B", "KB", "MB", "GB", "TB"};
        int digitGroups = (int) (Math.log10(size) / Math.log10(1024));
        return new DecimalFormat("#,##0.#").format(size / Math.pow(1024, digitGroups))
                + " " + units[digitGroups];
    }
}
