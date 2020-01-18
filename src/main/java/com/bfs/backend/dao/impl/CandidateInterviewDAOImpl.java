//package com.bfs.backend.dao.impl;
//
//import com.bfs.backend.dao.AbstractHibernateDAO;
//import com.bfs.backend.dao.CandidateInterviewDAO;
//import com.bfs.backend.domain.CandidateInterview;
//import org.hibernate.Session;
//import org.springframework.stereotype.Repository;
//
//import javax.persistence.criteria.CriteriaBuilder;
//import javax.persistence.criteria.CriteriaQuery;
//import javax.persistence.criteria.Root;
//import java.util.List;
//
//@Repository
//public class CandidateInterviewDAOImpl extends AbstractHibernateDAO<CandidateInterview> implements CandidateInterviewDAO {
//
//    public CandidateInterviewDAOImpl(){
//        this.setClazz(CandidateInterview.class);
//    }
//
////    @Override
////    public List<CandidateInterview> getCandidateByPosition(String PositionName){
////        Session session = getCurrentSession();
////        CriteriaBuilder cb = session.getCriteriaBuilder();
////        CriteriaQuery<CandidateInterview> cq = cb.createQuery(CandidateInterview.class);
////        Root<CandidateInterview> ciRoot = cq.from(CandidateInterview.class);
////        Root<>
////        cq.select(ciRoot);
////        cq.where(cb.equal())
////    }
//
//
//}
