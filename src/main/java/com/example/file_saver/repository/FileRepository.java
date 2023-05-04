package com.example.file_saver.repository;

import com.example.file_saver.entity.FileModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileRepository extends JpaRepository<FileModel, Long> {
}
