package com.bfs.backend.service.impl;

import com.bfs.backend.dao.AllCandidateDAO;
import com.bfs.backend.dao.CandidateDAO;
import com.bfs.backend.responseDomain.allCandidate;
import com.bfs.backend.responseDomain.homeCandidate;
import com.bfs.backend.service.AllCandidateService;
import com.bfs.backend.service.HomeCandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AllCandidateServiceImpl implements AllCandidateService {

    private AllCandidateDAO allCandidateDAO;
    @Autowired
    public void setAllCandidateDAO(AllCandidateDAO allCandidateDAO){
        this.allCandidateDAO = allCandidateDAO;
    }

    @Transactional
    @Override
    public List<allCandidate> getAllCandidate(int ID){
        List<allCandidate> candidatesList = allCandidateDAO.getAllCandidate();
        for(allCandidate item : candidatesList){
            if(item.getCreateUser()==ID){
                item.setIsBelongtoMe(true);
            }
        }
        return candidatesList;
    }

    @Transactional
    @Override
    public int FindEmployeeID(int ID){
        return allCandidateDAO.FindEmployeeID(ID);
    }

    @Transactional
    @Override
    public void UpdateEmployeeID(int userID, List<Integer> candidateID){
        for(Integer candidate : candidateID){
            allCandidateDAO.UpdateEmployeeID(userID, candidate);
        }
    }
}