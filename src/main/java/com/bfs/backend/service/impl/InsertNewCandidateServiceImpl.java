package com.bfs.backend.service.impl;


import com.bfs.backend.dao.CandidateDAO;
import com.bfs.backend.dao.InsertNewCandidateDAO;
import com.bfs.backend.domain.PotentialCandidate;
import com.bfs.backend.responseDomain.allCandidate;
import com.bfs.backend.service.EmailService;
import com.bfs.backend.service.EmployeeService;
import com.bfs.backend.service.InsertNewCandidateService;
import com.bfs.backend.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.Email;

@Service
public class InsertNewCandidateServiceImpl implements InsertNewCandidateService {
    private InsertNewCandidateDAO insertNewCandidateDAO;
    private EmailService emailService;
    private PositionService positionService;
    private EmployeeService employeeService;

    @Autowired
    public void setInsertNewCandidate(InsertNewCandidateDAO insertNewCandidateDAO){
        this.insertNewCandidateDAO = insertNewCandidateDAO;
    }

    @Autowired
    public void setEmailService(EmailService emailService){
        this.emailService = emailService;
    }

    @Autowired
    public void setEmployeeService(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    @Autowired
    public void setPositionService(PositionService positionService){
        this.positionService = positionService;
    }


    @Transactional
    @Override
    public void InsertNewCandidate(allCandidate allCandidate, int userId){
        PotentialCandidate pc = new PotentialCandidate();
        pc.setFirstName(allCandidate.getFirstName());
        pc.setMiddleName(" ");
        pc.setLastName(allCandidate.getLastName());
        pc.setEmail(allCandidate.getEmail());
        pc.setCellPhone(allCandidate.getCellPhone());
        pc.setResumeFileLocation(allCandidate.getResumeFileLocation());
        pc.setSendStatusID(1);
        pc.setRecruiterEmployeeID(employeeService.getEmployeeByUserID(userId).getID());
        pc.setPositionID(positionService.getPositionObject(allCandidate.getPositionName()).getID());
        pc.setComments(allCandidate.getComment());
        pc.setEmailTemplateID(emailService.getEmailByName(allCandidate.getEmailTemplateName()).getID());
        pc.setCreateUser(userId);
        pc.setModifyUser(userId);
        pc.setResource(allCandidate.getResource());
        insertNewCandidateDAO.InsertNewCandidate(pc);
    }
}
