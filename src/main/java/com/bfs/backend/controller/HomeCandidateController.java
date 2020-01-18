package com.bfs.backend.controller;

import com.bfs.backend.responseDomain.homeCandidate;
import com.bfs.backend.service.HomeCandidateService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HomeCandidateController {
    private HomeCandidateService homeCandidateService;

    @Autowired
    public void setHomeCandidatesService(HomeCandidateService homeCandidatesService) {
        this.homeCandidateService = homeCandidatesService;
    }
//success
    @GetMapping("/home")
    public List<homeCandidate> getHomeCandidate(){
        return homeCandidateService.getHomeCandidate(1);
    }
}
