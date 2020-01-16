package com.bfs.backend.dao.impl;

import com.bfs.backend.dao.AbstractHibernateDAO;
import com.bfs.backend.dao.InterviewDAO;
import com.bfs.backend.domain.*;
import com.bfs.backend.responseDomain.Interview;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public class InterviewDAOImpl extends AbstractHibernateDAO<Interview> implements InterviewDAO{

    public InterviewDAOImpl(){
        setClazz(Interview.class);
    }

    public List<Interview> getInterview(){
        Session session = getCurrentSession();
        List<Interview> list = null;
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Interview> cq = cb.createQuery(Interview.class);
        Root<CandidateInterview> ciRoot = cq.from(CandidateInterview.class);
        Root<Position> pRoot = cq.from(Position.class);
        Root<PotentialCandidate> pcRoot = cq.from(PotentialCandidate.class);
        Root<InternalPersonnel> ipRoot = cq.from(InternalPersonnel.class);
        Root<InterviewType> itRoot = cq.from(InterviewType.class);
        Root<Employee> eRoot = cq.from(Employee.class);
        cq.multiselect(
                ciRoot.get("ID"),
                ciRoot.get("InterviewStartDateTime"),
                ciRoot.get("InterviewDuration"),
                pRoot.get("PositionName"),
                pcRoot.get("FirstName"),
                pcRoot.get("LastName"),
                ciRoot.get("OverallRating"),
                ipRoot.get("FirstName"),
                ipRoot.get("MiddleName"),
                ipRoot.get("LastName"),
                ciRoot.get("Comments"),
                pcRoot.get("ResumeFileLocation"),
                itRoot.get("Sequence"),
                ciRoot.get("InterviewStatus"));
        cq.where(cb.equal(ciRoot.get("PotentialCandidateID"),pcRoot.get("ID")),
                cb.equal(ciRoot.get("InterviewTypeID"),itRoot.get("ID")),
                cb.equal(ciRoot.get("InterviewerEmplID"),eRoot.get("ID")),
                cb.equal(itRoot.get("PositionID"),pRoot.get("ID")),
                cb.equal(eRoot.get("InternalPersonnelID"), ipRoot.get("ID")));
        list = session.createQuery(cq).getResultList();
        return list;
    }

    public void insertInterview(Date InterviewStartDateTime, double InterviewDuration, String PositionName, String CandidateFirstName, String CandidateLastName, double OverallRating, String InterviewerFirstName, String InterviewerMiddleName, String InterviewerLastName, String Comments, String ResumeFileLocation, int Sequence, String InterviewStatus){

    }
}
