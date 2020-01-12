package com.bfs.backend.dao;

import com.bfs.backend.domain.User1;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.io.Serializable;
import java.util.List;

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

    protected Session  getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }
}