package com.bfs.backend.service;

import com.bfs.backend.domain.EmailTemplate;

import java.util.List;

public interface EmailTemplateService {
    List<String> getEmailTemplateName();
    List<EmailTemplate> getEmailTemplateList();
    void createEmailTemplate(EmailTemplate emailTemplate,Integer UserID);
}
