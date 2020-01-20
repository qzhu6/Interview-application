package com.bfs.backend.controller;

import com.bfs.backend.responseDomain.allCandidate;
import com.bfs.backend.responseDomain.homeCandidate;
import com.bfs.backend.service.AllCandidateService;
import com.bfs.backend.service.HomeCandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletContext;
import java.util.List;

@RestController
public class AllCandidateController {
    private AllCandidateService allCandidateService;
    @Autowired
    private ServletContext servletContext;

    @Autowired
    public void setAllCandidatesService(AllCandidateService allCandidatesService) {
        this.allCandidateService = allCandidatesService;
    }

    @GetMapping("/AllCandidate")

    public List<allCandidate> getAllCandidate(){
        Integer userID = (Integer)servletContext.getAttribute("userID");
        return allCandidateService.getAllCandidate(userID);
    }
}
