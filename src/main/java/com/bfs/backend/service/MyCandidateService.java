package com.bfs.backend.service;

import com.bfs.backend.responseDomain.myCandidate;

import java.util.List;

public interface MyCandidateService {
    List<myCandidate> getMyCandidate(int userID);
}
