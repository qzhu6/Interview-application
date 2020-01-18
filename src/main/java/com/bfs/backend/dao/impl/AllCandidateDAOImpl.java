package com.bfs.backend.dao.impl;

import com.bfs.backend.dao.AbstractHibernateDAO;
import com.bfs.backend.dao.AllCandidateDAO;
import com.bfs.backend.dao.CandidateDAO;
import com.bfs.backend.domain.*;
import com.bfs.backend.responseDomain.allCandidate;
import com.bfs.backend.responseDomain.homeCandidate;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class AllCandidateDAOImpl extends AbstractHibernateDAO implements AllCandidateDAO {
    public AllCandidateDAOImpl() {
        setClazz(AllCandidateDAO.class);
    }

    @Override
    public List<allCandidate> getAllCandidate(){
        Session session = getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<allCandidate> ac = cb.createQuery(allCandidate.class);
        Root<PotentialCandidate> pRoot = ac.from(PotentialCandidate.class);
        Root<Employee> eRoot = ac.from(Employee.class);
        Root<EmailTemplate> emailRoot = ac.from(EmailTemplate.class);
        Root<InternalPersonnel> iRoot = ac.from(InternalPersonnel.class);
        Root<Position> positionRoot = ac.from(Position.class);
        ac.multiselect(
                pRoot.get("ID"),
                pRoot.get("FirstName"),
                pRoot.get("LastName"),
                pRoot.get("Email"),
                pRoot.get("CellPhone"),
                positionRoot.get("PositionName"),
                emailRoot.get("EmailTemplateName"),
                iRoot.get("FirstName"),
                iRoot.get("LastName"),
                pRoot.get("CreateDate"),
                pRoot.get("Resource"),
                pRoot.get("Comments"),
                pRoot.get("ResumeFileLocation"),
                pRoot.get("CreateUser"));
        ac.where(
                cb.equal(pRoot.get("RecruiterEmployeeID"), eRoot.get("ID")),
                cb.equal(pRoot.get("EmailTemplateID"), emailRoot.get("ID")),
                cb.equal(eRoot.get("internalPersonnel"), iRoot.get("ID")),
                cb.equal(pRoot.get("position"), positionRoot.get("ID"))
        );
        List<allCandidate> list = session.createQuery(ac).getResultList();
        return list.stream().distinct().collect(Collectors.toList());
    }

    @Override
    public int FindEmployeeID(int ID){
        Session session = getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Integer> query = cb.createQuery(Integer.class);
        Root<Employee> eRoot = query.from(Employee.class);
        Root<InternalPersonnel> iRoot = query.from(InternalPersonnel.class);
        Root<User> uRoot = query.from(User.class);
        query.select(eRoot.get("ID"));
        query.where(
                cb.equal(iRoot.get("ID"),eRoot.get("InternalPersonnelID")),
                cb.equal(iRoot.get("ID"), uRoot.get("InternalPersonnelID")),
                cb.equal(uRoot.get("ID"), ID));
        List<Integer> list = session.createQuery(query).getResultList();
        return list.get(0);
    }

    @Override
    public void UpdateEmployeeID(int userID, int candidateID){
        Session session = getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaUpdate<PotentialCandidate> update = cb.createCriteriaUpdate(PotentialCandidate.class);
        Root pc = update.from(PotentialCandidate.class);
        update.set("RecruiterEmployeeID", userID);
        update.where(cb.equal(pc.get("ID"), candidateID));
        session.createQuery(update).executeUpdate();
    }
}
