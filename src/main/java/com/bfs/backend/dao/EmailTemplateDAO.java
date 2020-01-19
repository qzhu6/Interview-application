package com.bfs.backend.dao;

import com.bfs.backend.domain.EmailTemplate;

import java.util.List;

public interface EmailTemplateDAO {
    List<String> listStringEmailTemplateName();
    List<EmailTemplate> listEmailTemplate();
    void createEmailTemplate(EmailTemplate emailTemplate, Integer UserID);
    EmailTemplate lookUpEmailTemplate(String EmailTemplateName);
}
