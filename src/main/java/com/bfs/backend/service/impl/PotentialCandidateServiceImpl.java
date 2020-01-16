package com.bfs.backend.service.impl;

import com.bfs.backend.dao.PotentialCandidateDAO;
import com.bfs.backend.domain.PotentialCandidate;
import com.bfs.backend.service.PotentialCandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PotentialCandidateServiceImpl implements PotentialCandidateService {
    private PotentialCandidateDAO potentialCandidateDAO;

    @Autowired
    public void setPotentialCandidateDAO(PotentialCandidateDAO potentialCandidateDAO){
        this.potentialCandidateDAO = potentialCandidateDAO;
    }

    @Override
    @Transactional
    public PotentialCandidate getPotentialCandidate(String FirstName, String LastName){
        return this.potentialCandidateDAO.getPotentialCandidateByName(FirstName, LastName);
    }
}
