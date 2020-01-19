package com.bfs.backend.service.impl;


import com.bfs.backend.dao.CandidateDAO;
import com.bfs.backend.responseDomain.homeCandidate;
import com.bfs.backend.service.HomeCandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class HomeCandidateServiceImpl implements HomeCandidateService {
    private CandidateDAO candidateDAO;
    @Autowired
    public void setCandidateDAO(CandidateDAO candidateDAO){
        this.candidateDAO = candidateDAO;
    }

    @Transactional
    @Override
    public List<homeCandidate> getHomeCandidate(int id){
        return candidateDAO.getHomeCandidate(id);
    }
}
