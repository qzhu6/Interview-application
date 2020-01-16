package com.bfs.backend.dao.impl;

import com.bfs.backend.dao.AbstractHibernateDAO;
import com.bfs.backend.dao.PotentialCandidateDAO;
import com.bfs.backend.domain.Employee;
import com.bfs.backend.domain.PotentialCandidate;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

@Repository
public class PotentialCandidateDAOImpl extends AbstractHibernateDAO<PotentialCandidate> implements PotentialCandidateDAO {

    public PotentialCandidateDAOImpl(){
        this.setClazz(PotentialCandidate.class);
    }

    @Override
    public PotentialCandidate getPotentialCandidateByName(String FirstName, String LastName) {
        Session session = getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<PotentialCandidate> cq = cb.createQuery(PotentialCandidate.class);
        Root<PotentialCandidate> pcRoot = cq.from(PotentialCandidate.class);
        cq.select(pcRoot);
        cq.where(cb.equal(pcRoot.get("FirstName"), FirstName),
                cb.equal(pcRoot.get("LastName"), LastName));
        PotentialCandidate potentialCandidate = session.createQuery(cq).getSingleResult();
        return potentialCandidate;
    }
}
