package com.bfs.backend.service.impl;

import com.bfs.backend.dao.EmailDAO;
import com.bfs.backend.dao.EmployeeDAO;
import com.bfs.backend.domain.EmailTemplate;
import com.bfs.backend.service.EmailService;
import com.bfs.backend.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmailServiceImpl implements EmailService {
    private EmailDAO emailDAO;

    @Autowired
    public void setEmailDAO(EmailDAO emailDAO){this.emailDAO=emailDAO;}

    @Override
    @Transactional
    public EmailTemplate getEmailByName(String EmailTemplateName){
        return emailDAO.getEmailByName(EmailTemplateName);
    }
}
