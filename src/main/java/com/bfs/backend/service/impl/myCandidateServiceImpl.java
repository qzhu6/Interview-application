package com.bfs.backend.service.impl;

import com.bfs.backend.dao.CandidateDAO;
import com.bfs.backend.dao.MyCandidateDAO;
import com.bfs.backend.responseDomain.homeCandidate;
import com.bfs.backend.responseDomain.myCandidate;
import com.bfs.backend.service.HomeCandidateService;
import com.bfs.backend.service.MyCandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MyCandidateServiceImpl implements MyCandidateService {
    private MyCandidateDAO myCandidateDAO;
    @Autowired
    public void setMyCandidateDAO(MyCandidateDAO myCandidateDAO){
        this.myCandidateDAO = myCandidateDAO;
    }

    @Transactional
    @Override
    public List<myCandidate> getMyCandidate(int userID){
        return myCandidateDAO.getMyCandidate(userID);
    }

}

