package com.bfs.backend.dao.impl;

import com.bfs.backend.dao.AbstractHibernateDAO;
import com.bfs.backend.dao.myCandidateDAO;
import com.bfs.backend.domain.EmailTemplate;
import com.bfs.backend.domain.PotentialCandidate;
import com.bfs.backend.responseDomain.myCandidate;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class myCandidateDAOImpl extends AbstractHibernateDAO<myCandidate> implements myCandidateDAO {
    @Override
    public void updateCandidate(myCandidate candidate, EmailTemplate emailTemplate){
        Session session = getCurrentSession();
        PotentialCandidate potentialCandidate = session.get(PotentialCandidate.class, candidate.getID());
        potentialCandidate.setReachoutFlag(true);
        potentialCandidate.setSendStatusID(3);
        potentialCandidate.setEmailTemplateID(emailTemplate.getID());
        potentialCandidate.setReachoutFlag(true);
        session.merge(potentialCandidate);
    }
}
