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
import java.util.ArrayList;
import java.util.List;

@Repository
public class PotentialCandidateDAOImpl extends AbstractHibernateDAO<PotentialCandidate> implements PotentialCandidateDAO {

    public PotentialCandidateDAOImpl(){
        this.setClazz(PotentialCandidate.class);
    }

    @Override
    public PotentialCandidate getPotentialCandidateByName(String FirstName, String LastName) {
        System.out.println(FirstName);
        System.out.println(LastName);
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
    @Override
    public List<String> getCandidateName(){
        Session session = getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<PotentialCandidate> cq = cb.createQuery(PotentialCandidate.class);
        Root<PotentialCandidate> pcRoot = cq.from(PotentialCandidate.class);
        cq.multiselect(
                pcRoot.get("FirstName"),
                pcRoot.get("LastName"));
        List<PotentialCandidate> listCandidate = session.createQuery(cq).getResultList();
        List<String> listCandidateName = new ArrayList<String>();
        for(PotentialCandidate candidate: listCandidate){
            String fullName = candidate.getFirstName() +" " +candidate.getLastName();
            listCandidateName.add(fullName);
        }
        return listCandidateName;
    }
}
