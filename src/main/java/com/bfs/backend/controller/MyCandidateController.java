package com.bfs.backend.controller;

import com.bfs.backend.responseDomain.allCandidate;
import com.bfs.backend.responseDomain.myCandidate;
import com.bfs.backend.service.AllCandidateService;
import com.bfs.backend.service.MyCandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MyCandidateController {
    private MyCandidateService myCandidateService;

    @Autowired
    public void setMyCandidatesService(MyCandidateService myCandidatesService) {
        this.myCandidateService = myCandidatesService;
    }

    @GetMapping("/MyCandidate")
    public List<myCandidate> getMyCandidate(){
        return myCandidateService.getMyCandidate(1);
    }
}
