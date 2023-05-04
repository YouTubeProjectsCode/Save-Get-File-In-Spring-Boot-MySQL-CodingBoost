package com.example.file_saver.service;

import com.example.file_saver.entity.FileModel;
import com.example.file_saver.repository.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

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

    public ResponseEntity<byte[]> getFile(Long id) {
        Optional<FileModel> fileOptional = fileRepository.findById(id);
        if (fileOptional.isPresent()) {
            FileModel file = fileOptional.get();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.parseMediaType(file.getContentType()));
            headers.setContentDispositionFormData(file.getFileName(), file.getFileName());
            return new ResponseEntity<>(file.getData(), headers, HttpStatus.OK);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
