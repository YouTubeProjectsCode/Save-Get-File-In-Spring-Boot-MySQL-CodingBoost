package com.example.file_saver.controller;

import com.example.file_saver.entity.FileModel;
import com.example.file_saver.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@RestController
@RequestMapping("/api/file")
public class FileController {

    @Autowired
    private FileService fileService;

    @PostMapping("/upload")
    public ResponseEntity<FileModel> saveFile(@RequestParam("file")MultipartFile file){
        try {
            FileModel savedFile = fileService.saveFile(file);
            return new ResponseEntity<>(savedFile, HttpStatus.CREATED);
        } catch (IOException e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<byte[]> downloadFile(@PathVariable Long id) {
        return fileService.getFile(id);
    }
}
