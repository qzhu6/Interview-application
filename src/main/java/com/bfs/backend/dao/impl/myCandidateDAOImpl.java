package com.bfs.backend.dao.impl;

import com.bfs.backend.dao.AbstractHibernateDAO;
import com.bfs.backend.dao.myCandidateDAO;
import com.bfs.backend.domain.*;
import com.bfs.backend.responseDomain.myCandidate;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class myCandidateDAOImpl extends AbstractHibernateDAO implements myCandidateDAO {

    public myCandidateDAOImpl() {
        setClazz(myCandidateDAO.class);
    }

    @Override
    public List<myCandidate> getMyCandidate(int userID) {
        Session session = getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<myCandidate> ac = cb.createQuery(myCandidate.class);
        Root<PotentialCandidate> pRoot = ac.from(PotentialCandidate.class);
        Root<Employee> eRoot = ac.from(Employee.class);
        Root<EmailTemplate> emailRoot = ac.from(EmailTemplate.class);
        Root<InternalPersonnel> iRoot = ac.from(InternalPersonnel.class);
        Root<User> uRoot = ac.from(User.class);
        Root<SendStatus> sRoot= ac.from(SendStatus.class);
        ac.multiselect(
                pRoot.get("ID"),
                pRoot.get("FirstName"),
                pRoot.get("LastName"),
                pRoot.get("Email"),
                emailRoot.get("EmailTemplateName"),
                sRoot.get("Description"),
                sRoot.get("ModifyDate"));
        ac.where(
                cb.equal(pRoot.get("RecruiterEmployeeID"), eRoot.get("ID")),
                cb.equal(pRoot.get("EmailTemplateID"), emailRoot.get("ID")),
                cb.equal(eRoot.get("InternalPersonnelID"), iRoot.get("ID")),
                cb.equal(uRoot.get("InternalPersonnelID"), iRoot.get("ID")),
                cb.equal(pRoot.get("SendStatusID"), sRoot.get("ID")),
                cb.equal(uRoot.get("ID"), userID));
        List<myCandidate> list = session.createQuery(ac).getResultList();
        return list;
    }
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