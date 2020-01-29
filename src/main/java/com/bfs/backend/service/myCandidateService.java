package com.bfs.backend.service;

import com.bfs.backend.responseDomain.myCandidate;

import java.util.List;

public interface myCandidateService {
    List<myCandidate> getMyCandidate(int userID);
    void updateCandidate(List<myCandidate> listCandidate);
}
