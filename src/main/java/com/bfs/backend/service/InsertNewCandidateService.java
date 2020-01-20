package com.bfs.backend.service;

import com.bfs.backend.responseDomain.allCandidate;

public interface InsertNewCandidateService {
    void InsertNewCandidate(allCandidate allCandidate, int userId, String resumePath);
}
