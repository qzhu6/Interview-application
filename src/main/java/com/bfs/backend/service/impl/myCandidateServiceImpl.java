package com.bfs.backend.service.impl;

import com.bfs.backend.dao.EmailTemplateDAO;
import com.bfs.backend.dao.InterviewDAO;
import com.bfs.backend.dao.myCandidateDAO;
import com.bfs.backend.domain.EmailTemplate;
import com.bfs.backend.responseDomain.myCandidate;
import com.bfs.backend.service.SendEmailService;
import com.bfs.backend.service.myCandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class myCandidateServiceImpl implements myCandidateService {
    private myCandidateDAO myCandidateDAO;
    private InterviewDAO interviewDao;
    private EmailTemplateDAO emailTemplateDAO;
    private SendEmailService sendingEmailService;

    @Autowired
    public void setSendEmailService(SendEmailService sendingEmailService){
        this.sendingEmailService = sendingEmailService;
    }

    @Autowired
    public void setEmailTemplateDAO(EmailTemplateDAO emailTemplateDAO){
        this.emailTemplateDAO = emailTemplateDAO;
    }

    @Autowired
    public void setMyCandidateDAO(myCandidateDAO myCandidateDAO){
        this.myCandidateDAO = myCandidateDAO;
    }

    @Autowired
    public void setInterviewDao(InterviewDAO interviewDao){this.interviewDao = interviewDao;}


    @Transactional
    @Override
    public List<myCandidate> getMyCandidate(int userID){
        return myCandidateDAO.getMyCandidate(userID);
    }

//    @Override
//    @Transactional
//    public void updateCandidate(List<myCandidate> listCandidate){
//        for(myCandidate candidate: listCandidate){
//            EmailTemplate emailTemplate = emailTemplateDAO.lookUpEmailTemplate(candidate.getEmailTemplateName());
//            myCandidateDAO.updateCandidate(candidate, emailTemplate);
//        }
//    }
    @Override
    @Transactional
    public void updateCandidate(List<myCandidate> listCandidate){
        for(myCandidate candidate: listCandidate){
            EmailTemplate emailTemplate = emailTemplateDAO.lookUpEmailTemplate(candidate.getEmailTemplateName());
            sendingEmailService.sendEmailTemplate(emailTemplate, candidate.getEmail(),candidate.getFirstName());
            myCandidateDAO.updateCandidate(candidate, emailTemplate);
        }
    }


}

