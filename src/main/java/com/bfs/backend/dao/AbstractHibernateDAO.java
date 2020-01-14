package com.bfs.backend.dao;

import com.bfs.backend.domain.CandidateInterview;
import com.bfs.backend.domain.InterviewType;

import com.bfs.backend.domain.InternalPersonnel;
import com.bfs.backend.domain.User;

import com.bfs.backend.domain.User1;
//import com.bfs.backend.domain.UserInternalPersonnel;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public abstract class AbstractHibernateDAO<T extends Serializable> {

    @Autowired
    protected SessionFactory sessionFactory;

    protected Class<T> clazz;

    protected final void setClazz(final Class<T> clazzToSet) {
        clazz = clazzToSet;
    }
    public User1 getUserByNameOrEmailHibernate(String str, String nameOrEmail) {
        Session session = getCurrentSession();
        User1 user = null;
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<User1> cq = cb.createQuery(User1.class);
        Root<User1> userRoot = cq.from(User1.class);
        cq.select(userRoot);
        cq.where(cb.equal(userRoot.get(nameOrEmail), str));
        List<User1> users = session.createQuery(cq).getResultList();
        System.out.println(users);
        if (users.size() != 0) {
            user = users.get(0);
        }
        return user;
    }

    public void testSomeCandidate() throws ParseException {
        String sDate1="12/01/2020 21:03:04";
        Date date1=new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(sDate1);
        Session session = getCurrentSession();
        CandidateInterview ci = new CandidateInterview();
        InterviewType it = new InterviewType();
        session.save(it);
        ci.setPotentailCandidateID(1);
        ci.setInterviewEmplID(2);
        ci.setOverallRating(1.3);
        ci.setComments("yes");
        ci.setInterviewStartDateTime(date1);
        ci.setInterviewDuration(1.8);
        ci.setInterviewEndDateTime(date1);
        ci.setCreateDate(date1);
        ci.setModifyDate(date1);
        ci.setCreateUser(1);
        ci.setModifyUser(2);
        ci.setInterviewType(it);
        it.setInterviewTypeName("adsd");
        it.setInterviewTypeDescription("asdasd");
        it.setPositionID(3);
        it.setSequence(2);
        it.setDefaultInterviewerEmployeeID(3);
        it.setCreateDate(date1);
        it.setModifyDate(date1);
        it.setCreateUser(1);
        it.setModifyUser(2);
        Set<CandidateInterview> a=new HashSet<>();
        a.add(ci);
        it.setCandidateInterviewSet(a);
        session.merge(ci);
        session.merge(it);
    }

//
//=======
//    public UserInternalPersonnel getSomething(){
//        Session session = getCurrentSession();
//        UserInternalPersonnel userInternalPersonnel = null;
//        CriteriaBuilder cb = session.getCriteriaBuilder();
//        CriteriaQuery<UserInternalPersonnel> cq = cb.createQuery(UserInternalPersonnel.class);
//        Root<InternalPersonnel> iRoot = cq.from(InternalPersonnel.class);
//        Root<User> uRoot = cq.from(User.class);
//        cq.multiselect(
//                iRoot.get("FirstName"),
//                uRoot.get("UserName"));
//        cq.where(cb.equal(iRoot.get("ID"), uRoot.get("InternalPersonnelID")));
//        List<UserInternalPersonnel> list = session.createQuery(cq).getResultList();
//        userInternalPersonnel = list.get(0);
//        return userInternalPersonnel;
//    }


    protected Session  getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }
}