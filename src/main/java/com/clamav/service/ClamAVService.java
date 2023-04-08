package com.clamav.service;

import com.clamav.dto.GenericResponse;
import org.springframework.web.multipart.MultipartFile;

public interface ClamAVService {
    GenericResponse uploadFile(MultipartFile files);
}
