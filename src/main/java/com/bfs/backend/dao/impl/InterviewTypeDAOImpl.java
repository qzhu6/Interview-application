package com.bfs.backend.dao.impl;

import com.bfs.backend.dao.AbstractHibernateDAO;
import com.bfs.backend.dao.InterviewTypeDAO;
import com.bfs.backend.domain.InterviewType;
import com.bfs.backend.domain.Position;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

@Repository
public class InterviewTypeDAOImpl extends AbstractHibernateDAO implements InterviewTypeDAO {

    @Override
    public InterviewType getInterviewType(Position position, Integer Sequence){
        Session session = getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<InterviewType> cq = cb.createQuery(InterviewType.class);
        Root<InterviewType> itRoot = cq.from(InterviewType.class);
        CriteriaQuery<InterviewType> all = cq.select(itRoot);
        cq.where(cb.equal(itRoot.get("Sequence"), Sequence),
                cb.equal(itRoot.get("PositionID"), position.getID()));
        InterviewType interviewType = session.createQuery(cq).getSingleResult();
        return interviewType;
    }
}
