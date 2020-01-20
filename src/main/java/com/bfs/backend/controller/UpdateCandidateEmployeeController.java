package com.bfs.backend.controller;

import com.bfs.backend.responseDomain.candidateIdList;
import com.bfs.backend.service.AllCandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletContext;
import java.util.List;

@RestController
public class UpdateCandidateEmployeeController {
    private AllCandidateService allCandidateService;
    @Autowired
    private ServletContext servletContext;
    @Autowired
    public void setAllCandidatesService(AllCandidateService allCandidatesService) {
        this.allCandidateService = allCandidatesService;
    }

    @PostMapping("/AddToCandidate")
    public void UpdateCandidateEmployee( @RequestBody candidateIdList a){
        Integer userID = (Integer)servletContext.getAttribute("userID");
        int EmployeeId = allCandidateService.FindEmployeeID(userID);
        List<Integer> candidateId = a.getCandidate();
        allCandidateService.UpdateEmployeeID(EmployeeId, candidateId);
    }
}
