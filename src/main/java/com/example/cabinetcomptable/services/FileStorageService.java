package com.example.cabinetcomptable.services;

import org.springframework.web.multipart.MultipartFile;

public interface FileStorageService {

    String uploadFile(MultipartFile file, String pathFolder);
    String loadFile(String pathFile);
    void deleteFile(String pathFile);
}
