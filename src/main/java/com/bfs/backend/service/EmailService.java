package com.bfs.backend.service;

import com.bfs.backend.domain.EmailTemplate;

public interface EmailService {
    EmailTemplate getEmailByName(String EmailTemplateName);
}
