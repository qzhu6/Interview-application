package com.bfs.backend.service.impl;

import com.bfs.backend.service.FileService;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import org.springframework.core.io.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Component
public class FileServiceImpl implements FileService {
    private static final String FILE_DIRECTORY = "D:\\Java Project\\Team";

    public void storeFile(MultipartFile file) throws IOException {
        Path filePath = Paths.get(FILE_DIRECTORY + "\\" + file.getOriginalFilename());
        Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
    }

    public Resource getFileSystem(String filename, HttpServletResponse response) {
        return getResource(filename, response);
    }

    private Resource getResource(String filename, HttpServletResponse response) {
        response.setContentType("text/csv; charset=utf-8");
        response.setHeader("Content-Disposition", "attachment; filename=" + filename);
        response.setHeader("filename", filename);
        Resource resource = null;
        resource = new FileSystemResource(FILE_DIRECTORY +"\\" +  filename);
        return resource;
    }
}
