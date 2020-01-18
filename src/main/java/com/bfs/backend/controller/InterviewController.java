package com.bfs.backend.controller;

import com.bfs.backend.domain.EmailTemplate;
import com.bfs.backend.responseDomain.Interview;
import com.bfs.backend.service.EmailTemplateService;
import com.bfs.backend.service.InterviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class InterviewController {

    private String cuiBo;
    private InterviewService interviewService;
    private EmailTemplateService emailTemplateService;

    @Autowired
    public void setInterviewService(InterviewService interviewService){
        this.interviewService = interviewService;
    }

    @Autowired
    public void setEmailTemplateService(EmailTemplateService emailTemplateService){
        this.emailTemplateService = emailTemplateService;
    }

    @GetMapping("/Interview")
    public List<List<Interview>> getInterview(){
        List<List<Interview>> listBoCui = interviewService.getListInterview("BackEnd");
        return listBoCui;
    }

    @GetMapping("/ListPosition")
    public List<String> getListPosition(){
        return interviewService.getStringListPositionName();
    }

    @GetMapping("/ListInterviewByName")
    public List<Interview> getListInterviewByName(){
        return interviewService.getListInterviewByPositionName(cuiBo);
    }

    @GetMapping(value="/ListEmailTemplateName")
    public List<String> getEmailTemplateName(){
        List<String> listEmailTemplateName = emailTemplateService.getEmailTemplateName();
        return listEmailTemplateName;
    }


    @GetMapping(value="/ListEmailTemplate")
    public List<EmailTemplate> getEmailTemplate(){
        List<EmailTemplate> listEmailTemplate = emailTemplateService.getEmailTemplateList();
        return listEmailTemplate;
    }

    @PostMapping(value="/NewInterview")
    public void getNewInterview(@RequestBody Interview interview){
        interviewService.createNewInterview(interview);
    }

    @PostMapping(value="/PositionName")
    public void getPositionName(@RequestBody String PositionName){
        cuiBo = PositionName;
    }

    @PostMapping(value="/EmailTemplate")
    public void getNewEmailTemplate(@RequestBody EmailTemplate EmailTemplate){
        emailTemplateService.createEmailTemplate(EmailTemplate);
    }
}
