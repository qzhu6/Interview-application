package com.bfs.backend.dao;

import com.bfs.backend.domain.PotentialCandidate;

public interface PotentialCandidateDAO {
    PotentialCandidate getPotentialCandidateByName(String FirstName, String LastName);
}
