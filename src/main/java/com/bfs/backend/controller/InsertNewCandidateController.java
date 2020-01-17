package com.bfs.backend.controller;


import com.bfs.backend.responseDomain.allCandidate;
import com.bfs.backend.responseDomain.homeCandidate;
import com.bfs.backend.service.HomeCandidateService;
import com.bfs.backend.service.InsertNewCandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class InsertNewCandidateController {
    private InsertNewCandidateService insertNewCandidateService;

    @Autowired
    public void setInsertNewCandidateService(InsertNewCandidateService insertNewCandidateService) {
        this.insertNewCandidateService = insertNewCandidateService;
    }

    @PostMapping("/NewCandidate")
    public void InsertCandidate(@RequestBody allCandidate a){
        System.out.println(a.getFirstName());
        insertNewCandidateService.InsertNewCandidate(a, 1);
    }
}

