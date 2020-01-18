package com.bfs.backend.service;

import com.bfs.backend.responseDomain.homeCandidate;
import com.bfs.backend.responseDomain.myCandidate;

import java.util.List;

public interface HomeCandidateService {
    List<homeCandidate> getHomeCandidate(int id);
}
