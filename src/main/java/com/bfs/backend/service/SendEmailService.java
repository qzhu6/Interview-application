package com.bfs.backend.service;

import com.bfs.backend.domain.EmailTemplate;

public interface SendEmailService {
    void sendEmailTemplate(EmailTemplate emailTemplate, String receiver, String FirstName);
}

