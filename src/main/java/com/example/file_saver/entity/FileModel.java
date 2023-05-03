package com.example.file_saver.entity;


import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "files")
@Data
public class FileModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fileName;

    private String contentType;

    @Lob
    private byte[] data;

}
