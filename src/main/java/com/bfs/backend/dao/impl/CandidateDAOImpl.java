package com.bfs.backend.dao.impl;

import com.bfs.backend.dao.AbstractHibernateDAO;
import com.bfs.backend.dao.CandidateDAO;
import com.bfs.backend.dao.UserDAO;
import com.bfs.backend.domain.*;
import com.bfs.backend.responseDomain.homeCandidate;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.text.ParseException;
import java.util.List;

@Repository
public class CandidateDAOImpl extends AbstractHibernateDAO implements CandidateDAO{
    public CandidateDAOImpl() {
        setClazz(CandidateDAO.class);
    }

    @Override
    public List<homeCandidate> getHomeCandidate(int ID){
        Session session = getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<homeCandidate> hc = cb.createQuery(homeCandidate.class);
        Root<CandidateInterview> cRoot = hc.from(CandidateInterview.class);
        Root<PotentialCandidate> pRoot = hc.from(PotentialCandidate.class);
        Root<Employee> eRoot = hc.from(Employee.class);
        Root<InternalPersonnel> iRoot = hc.from(InternalPersonnel.class);
        Root<Position> positionRoot = hc.from(Position.class);
        Root<User> uRoot = hc.from(User.class);
        hc.multiselect(
                cRoot.get("InterviewStartDateTime"),
                cRoot.get("InterviewDuration"),
                pRoot.get("FirstName"),
                pRoot.get("LastName"),
                iRoot.get("FirstName"),
                iRoot.get("LastName"),
                pRoot.get("CellPhone"),
                positionRoot.get("PositionName"),
                pRoot.get("ResumeFileLocation"));
        Predicate userMatch = cb.equal(uRoot.get("ID"), ID);
        Predicate createUserMatch = cb.equal(cRoot.get("CreateUser"), ID);
        hc.where(
                cb.equal(cRoot.get("potentialCandidate"), pRoot.get("ID")),
                cb.equal(cRoot.get("employee"), eRoot.get("ID")),
                cb.equal(eRoot.get("internalPersonnel"), iRoot.get("ID")),
                cb.equal(pRoot.get("position"), positionRoot.get("ID")),
                cb.equal(iRoot.get("ID"), uRoot.get("internalPersonnel")),
                cb.or(userMatch, createUserMatch));
            List<homeCandidate> list = session.createQuery(hc).getResultList();
        return list;
}}

