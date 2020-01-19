package com.bfs.backend.controller;

import com.bfs.backend.responseDomain.myCandidate;
import com.bfs.backend.service.myCandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MyCandidateController {
    private com.bfs.backend.service.myCandidateService myCandidateService;

    @Autowired
    public void setMyCandidatesService(myCandidateService myCandidatesService) {
        this.myCandidateService = myCandidatesService;
    }

    @GetMapping("/MyCandidate")
    public List<myCandidate> getMyCandidate(){
        return myCandidateService.getMyCandidate(1);
    }
}
