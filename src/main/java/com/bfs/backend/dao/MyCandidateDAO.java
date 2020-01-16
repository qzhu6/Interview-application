package com.bfs.backend.dao;

import com.bfs.backend.responseDomain.homeCandidate;
import com.bfs.backend.responseDomain.myCandidate;

import java.util.List;

public interface MyCandidateDAO {
    List<myCandidate> getMyCandidate(int userID);
}
