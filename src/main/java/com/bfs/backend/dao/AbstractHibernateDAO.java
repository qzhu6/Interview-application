package com.bfs.backend.dao;

import com.bfs.backend.domain.*;


import com.bfs.backend.responseDomain.homeCandidate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

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


    public List<homeCandidate> getHomeCandidateByHibernate(int ID){
        Session session = getCurrentSession();
        homeCandidate homeCandidate = null;
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
                pRoot.get("CellPhone"),
                iRoot.get("FirstName"),
                iRoot.get("LastName"),
                positionRoot.get("PositionName"),
                pRoot.get("ResumeFileLocation"));
        hc.where(cb.equal(cRoot.get("potentialCandidate"), pRoot.get("ID")));
        hc.where(cb.equal(cRoot.get("employee"), eRoot.get("ID")));
        hc.where(cb.equal(eRoot.get("internalPersonnel"), iRoot.get("ID")));
        hc.where(cb.equal(pRoot.get("position"), positionRoot.get("ID")));
        hc.where(cb.equal(iRoot.get("ID"), uRoot.get("internalPersonnel")));
        hc.where(cb.equal(uRoot.get("ID"), ID));
        List<homeCandidate> list = session.createQuery(hc).getResultList();
        return list;
    }


    public UserInternalPersonnel testSomeCandidate() throws ParseException {
        String sDate1="12/01/2020 21:03:04";
        Date date1=new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(sDate1);
        Session session = getCurrentSession();
        UserInternalPersonnel userInternalPersonnel = null;
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<UserInternalPersonnel> cq = cb.createQuery(UserInternalPersonnel.class);
        Root<InternalPersonnel> iRoot = cq.from(InternalPersonnel.class);
        Root<User> uRoot = cq.from(User.class);
        Root<Role> rRoot = cq.from(Role.class);
        Root<Permission> pRoot = cq.from(Permission.class);
        Root<UserRole> urRoot = cq.from(UserRole.class);
        Root<RolePermission> rpRoot = cq.from(RolePermission.class);
        cq.multiselect(
                iRoot.get("FirstName"),
                uRoot.get("UserName"),
                rRoot.get("RoleName"),
                pRoot.get("Description"));
        cq.where(cb.equal(iRoot.get("ID"), uRoot.get("InternalPersonnelID")));
        cq.where(cb.equal(uRoot.get("ID"), urRoot.get("UserID")));
        cq.where(cb.equal(rRoot.get("ID"), urRoot.get("RoleID")));
        cq.where(cb.equal(rRoot.get("ID"), rpRoot.get("RoleID")));
        cq.where(cb.equal(pRoot.get("ID"),rpRoot.get("PermissionID")));
        List<UserInternalPersonnel> list = session.createQuery(cq).getResultList();
        userInternalPersonnel = list.get(0);
        return userInternalPersonnel;
    }

    public RecruitingTesting testRecruiting(){
        Session session = getCurrentSession();

        RecruitingTesting recruitingTesting = null;
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<RecruitingTesting> cq = cb.createQuery(RecruitingTesting.class);
        Root<Position> pRoot = cq.from(Position.class);
        Root<SendStatus> sRoot = cq.from(SendStatus.class);
        Root<EmailTemplate> eRoot = cq.from(EmailTemplate.class);
        Root<PotentialCandidate> pcRoot = cq.from(PotentialCandidate.class);
        Root<InterviewType> iRoot = cq.from(InterviewType.class);
        Root<CandidateInterview> cRoot = cq.from(CandidateInterview.class);
        cq.multiselect(
                pRoot.get("PositionName"),
                sRoot.get("Description"),
                eRoot.get("EmailSubject"),
                pcRoot.get("Email"),
                iRoot.get("InterviewTypeDescription"));
        cq.where(cb.equal(pRoot.get("ID"),iRoot.get("PositionID")));
        cq.where(cb.equal(pcRoot.get("ID"),cRoot.get("PotentialCandidateID")));
        cq.where(cb.equal(iRoot.get("ID"), cRoot.get("InterviewTypeID")));
        cq.where(cb.equal(sRoot.get("ID"), pcRoot.get("PositionID")));
        List<RecruitingTesting> list = session.createQuery(cq).getResultList();
        recruitingTesting = list.get(0);
        return recruitingTesting;
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