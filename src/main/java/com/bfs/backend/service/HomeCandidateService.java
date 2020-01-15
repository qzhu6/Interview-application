package com.bfs.backend.service;

import com.bfs.backend.responseDomain.homeCandidate;

import java.util.List;

public interface HomeCandidateService {
    List<homeCandidate> getHomeCandidate(int id);
}
