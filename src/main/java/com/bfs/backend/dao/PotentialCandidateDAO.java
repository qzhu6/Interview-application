package com.bfs.backend.dao;

import com.bfs.backend.domain.PotentialCandidate;

import java.util.List;

public interface PotentialCandidateDAO {
    PotentialCandidate getPotentialCandidateByName(String FirstName, String LastName);
    List<String> getCandidateName();
}
