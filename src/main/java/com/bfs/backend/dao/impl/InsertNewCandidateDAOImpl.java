package com.bfs.backend.dao.impl;

import com.bfs.backend.dao.AbstractHibernateDAO;
import com.bfs.backend.dao.EmployeeDAO;
import com.bfs.backend.dao.InsertNewCandidateDAO;
import com.bfs.backend.domain.Employee;
import com.bfs.backend.domain.PotentialCandidate;
import com.bfs.backend.service.EmailService;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

@Repository
public class InsertNewCandidateDAOImpl extends AbstractHibernateDAO implements InsertNewCandidateDAO{
    private InsertNewCandidateDAO insertNewCandidateDAO;

    public InsertNewCandidateDAOImpl(){
        this.setClazz(PotentialCandidate.class);
    }

    @Override
    public void InsertNewCandidate(PotentialCandidate potentialCandidate){
        Session session = getCurrentSession();
        session.persist(potentialCandidate);
    }

}
