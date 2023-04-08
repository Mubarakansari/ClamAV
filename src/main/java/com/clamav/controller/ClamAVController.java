package com.clamav.controller;

import com.clamav.dto.GenericResponse;
import com.clamav.service.ClamAVService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("clamAVController")
@RequiredArgsConstructor
public class ClamAVController {
    public final ClamAVService clamAVService;

    @PostMapping(value = "upload-file", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<GenericResponse> uploadFile(@RequestPart("file") MultipartFile files) {
        return ResponseEntity.status(HttpStatus.OK).body(clamAVService.uploadFile(files));
    }
}
