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
//        CriteriaBuilder builder = session.getCriteriaBuilder();
//        CriteriaQuery<PotentialCandidate> query = builder.createQuery(PotentialCandidate.class);
//        Root<PotentialCandidate> root = query.from(PotentialCandidate.class);
//        session.merge(potentialCandidate);
//        PotentialCandidate pc = potentialCandidate;
//        PotentialCandidate pc = new PotentialCandidate();
//        pc.setFirstName(potentialCandidate.getFirstName());
//        pc.setMiddleName(potentialCandidate.getMiddleName());
//        pc.setLastName(potentialCandidate.getLastName());
//        pc.setEmail(potentialCandidate.getEmail());
//        pc.setCellPhone(potentialCandidate.getCellPhone());
//        pc.setResumeFileLocation(potentialCandidate.getResumeFileLocation());
//        pc.setSendStatusID(1);
//        pc.setRecruiterEmployeeID(potentialCandidate.getRecruiterEmployeeID());
//        pc.setPositionID(potentialCandidate.getPositionID());
//        pc.setComments(potentialCandidate.getComments());
//        pc.setReachoutFlag(potentialCandidate.getReachoutFlag());
//        pc.setActiveFlag(potentialCandidate.getActiveFlag());
//        pc.setEmailTemplateID(potentialCandidate.getEmailTemplateID());
//        pc.setCreateDate(potentialCandidate.getCreateDate());
//        pc.setModifyDate(potentialCandidate.getModifyDate());
//        pc.setCreateUser(potentialCandidate.getCreateUser());
//        pc.setModifyUser(potentialCandidate.getModifyUser());
        session.persist(potentialCandidate);
    }

}
