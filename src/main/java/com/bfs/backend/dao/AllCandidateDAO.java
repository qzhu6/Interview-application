package com.bfs.backend.dao;

import com.bfs.backend.responseDomain.allCandidate;
import com.bfs.backend.responseDomain.homeCandidate;

import java.util.List;

public interface AllCandidateDAO {
    List<allCandidate> getAllCandidate();
    int FindEmployeeID(int ID);
    void UpdateEmployeeID(int userID, int candidateID);
}
