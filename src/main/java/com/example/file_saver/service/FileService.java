package com.example.file_saver.service;

import com.example.file_saver.entity.FileModel;
import com.example.file_saver.repository.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class FileService {

    @Autowired
    private FileRepository fileRepository;


    public FileModel saveFile(MultipartFile file) throws IOException {
        FileModel fileModel = new FileModel();
        fileModel.setContentType(file.getContentType());
        fileModel.setFileName(file.getOriginalFilename());
        fileModel.setData(file.getBytes());
        return fileRepository.save(fileModel);
    }
}
