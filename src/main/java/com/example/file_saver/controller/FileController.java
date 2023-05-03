package com.example.file_saver.controller;

import com.example.file_saver.entity.FileModel;
import com.example.file_saver.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/files")
public class FileController {

    @Autowired
    private FileService fileService;

    @PostMapping
    public ResponseEntity<FileModel> saveFile(@RequestParam("file")MultipartFile file){
        try {
            FileModel savedFile = fileService.saveFile(file);
            return new ResponseEntity<>(savedFile, HttpStatus.CREATED);
        } catch (IOException e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
