package com.bfs.backend.dao;

import com.bfs.backend.domain.EmailTemplate;
import com.bfs.backend.responseDomain.myCandidate;

import java.util.List;

public interface myCandidateDAO {
    void updateCandidate(myCandidate candidate, EmailTemplate emailTemplate);
}
