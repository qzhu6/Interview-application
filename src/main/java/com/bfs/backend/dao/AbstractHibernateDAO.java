package com.bfs.backend.dao;

import com.bfs.backend.domain.*;


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
        List<UserInternalPersonnel> list = session.createQuery(cq).getResultList();
        userInternalPersonnel = list.get(0);
        return userInternalPersonnel;
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