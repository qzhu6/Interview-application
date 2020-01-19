package com.bfs.backend.controller;

import com.bfs.backend.domain.EmailTemplate;
import com.bfs.backend.responseDomain.Interview;
import com.bfs.backend.responseDomain.PositionName;
import com.bfs.backend.responseDomain.myCandidate;
import com.bfs.backend.responseDomain.myCandidateList;
import com.bfs.backend.service.EmailTemplateService;
import com.bfs.backend.service.InterviewService;
import com.bfs.backend.service.myCandidateService;
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
    private myCandidateService  myCandidateService;

    @Autowired
    public void setInterviewService(InterviewService interviewService){
        this.interviewService = interviewService;
    }

    @Autowired
    public void setEmailTemplateService(EmailTemplateService emailTemplateService){
        this.emailTemplateService = emailTemplateService;
    }

    @Autowired
    public void setMyCandidateService(myCandidateService myCandidateService){
        this.myCandidateService = myCandidateService;
    }

//    @GetMapping("/Interview")
//    public List<List<Interview>> getInterview(){
//        List<List<Interview>> listBoCui = interviewService.getListInterview();
//        return listBoCui;
//    }
   @PostMapping("/Interview")
    public List<List<Interview>> getInterview(@RequestBody PositionName pn){
        System.out.println(pn.getPositionName());
    List<List<Interview>> listBoCui = interviewService.getListInterview(pn.getPositionName());
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
        System.out.println(interview);
        interviewService.createNewInterview(interview);
    }

    @PostMapping(value="/PositionName")
    public void getPositionName(@RequestBody String PositionName){
        cuiBo = PositionName;
    }

    @PostMapping(value="/EmailTemplate")
    public void getNewEmailTemplate(@RequestBody EmailTemplate EmailTemplate){
        emailTemplateService.createEmailTemplate(EmailTemplate,1);
    }

    @PostMapping(value="/UpdateCandidate")
    public void updateCandidate(@RequestBody myCandidateList listCandidate){

        myCandidateService.updateCandidate(listCandidate.getCandidateList());
    }

    @GetMapping(value="/EmployeeName")
    public List<String> getEmployeeName(){
        List<String> listEmployeeName = interviewService.getEmployeeName();
        return listEmployeeName;
    }
    @GetMapping(value="/CandidateName")
    public List<String> getCandidateName(){
        List<String> listCandidateName = interviewService.getCandidateName();
        return listCandidateName;
    }
}
