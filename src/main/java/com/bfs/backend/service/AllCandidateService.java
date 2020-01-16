package com.bfs.backend.service;

import com.bfs.backend.responseDomain.allCandidate;
import com.bfs.backend.responseDomain.homeCandidate;

import java.util.List;

public interface AllCandidateService {
    List<allCandidate> getAllCandidate(int ID);
    int FindEmployeeID(int ID);
    void UpdateEmployeeID(int userID, List<Integer> candidateID);
}
