package com.bfs.backend.service;

import org.springframework.web.multipart.MultipartFile;

import org.springframework.core.io.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface FileService {
        void storeFile(MultipartFile file) throws IOException;
        Resource getFileSystem(String filename, HttpServletResponse response);
}

