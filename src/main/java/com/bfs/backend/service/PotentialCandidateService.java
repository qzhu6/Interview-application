package com.bfs.backend.service;

import com.bfs.backend.domain.PotentialCandidate;

public interface PotentialCandidateService {
    PotentialCandidate getPotentialCandidate(String FirstName, String LastName);
}
