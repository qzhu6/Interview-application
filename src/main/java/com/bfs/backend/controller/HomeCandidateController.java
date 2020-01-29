package com.bfs.backend.controller;

import com.bfs.backend.responseDomain.homeCandidate;
import com.bfs.backend.service.HomeCandidateService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletContext;
import java.util.List;

@RestController
public class HomeCandidateController {
    private HomeCandidateService homeCandidateService;
    @Autowired
    private ServletContext servletContext;

    @Autowired
    public void setHomeCandidatesService(HomeCandidateService homeCandidatesService) {
        this.homeCandidateService = homeCandidatesService;
    }


    @GetMapping("/home")
    public List<homeCandidate> getHomeCandidate(){
        Integer userID = (Integer)servletContext.getAttribute("userID");
        return homeCandidateService.getHomeCandidate(userID);
    }
}
