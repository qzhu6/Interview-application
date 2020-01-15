package com.bfs.backend.dao.impl;

import com.bfs.backend.dao.AbstractHibernateDAO;
import com.bfs.backend.dao.CandidateDAO;
import com.bfs.backend.dao.UserDAO;
import com.bfs.backend.domain.User1;
import com.bfs.backend.responseDomain.homeCandidate;
import org.springframework.stereotype.Repository;

import java.text.ParseException;
import java.util.List;

@Repository
public class CandidateDAOImpl extends AbstractHibernateDAO implements CandidateDAO{
    public CandidateDAOImpl() {
        setClazz(CandidateDAO.class);
    }

    @Override
    public List<homeCandidate> getHomeCandidate(int id){
        return getHomeCandidateByHibernate(id);
    }
}

