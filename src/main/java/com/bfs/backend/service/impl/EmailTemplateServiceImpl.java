package com.bfs.backend.service.impl;

import com.bfs.backend.dao.EmailTemplateDAO;
import com.bfs.backend.domain.EmailTemplate;
import com.bfs.backend.service.EmailTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmailTemplateServiceImpl implements EmailTemplateService {
    private EmailTemplateDAO emailTemplateDAO;

    @Autowired
    public void setEmailTemplateDAO(EmailTemplateDAO emailTemplateDAO){
        this.emailTemplateDAO = emailTemplateDAO;
    }

    @Override
    @Transactional
    public List<String> getEmailTemplateName(){
        return this.emailTemplateDAO.listStringEmailTemplateName();
    }

    @Override
    @Transactional
    public List<EmailTemplate> getEmailTemplateList(){
        return this.emailTemplateDAO.listEmailTemplate();
    }

    @Override
    @Transactional
    public void createEmailTemplate(EmailTemplate emailTemplate,Integer UserID){
        this.emailTemplateDAO.createEmailTemplate(emailTemplate, UserID);
    }
}
