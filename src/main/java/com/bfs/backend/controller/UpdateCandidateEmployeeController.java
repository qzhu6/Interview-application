package com.bfs.backend.controller;

import com.bfs.backend.responseDomain.allCandidate;
import com.bfs.backend.responseDomain.candidateIdList;
import com.bfs.backend.service.AllCandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UpdateCandidateEmployeeController {
    private AllCandidateService allCandidateService;
    private candidateIdList candidateIdList;

    @Autowired
    public void setAllCandidatesService(AllCandidateService allCandidatesService) {
        this.allCandidateService = allCandidatesService;
    }

    @PostMapping("/AddToCandidate")
    public void UpdateCandidateEmployee( @RequestBody candidateIdList a){
        int EmployeeId = allCandidateService.FindEmployeeID(1);
        List<Integer> candidateId = a.getCandidate();
        allCandidateService.UpdateEmployeeID(EmployeeId, candidateId);
    }
}
