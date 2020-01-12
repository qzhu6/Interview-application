package com.bfs.backend.dao.impl;


import com.bfs.backend.dao.AbstractHibernateDAO;
import com.bfs.backend.dao.UserDAO;
import com.bfs.backend.domain.User1;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAOImpl  extends AbstractHibernateDAO implements UserDAO {


    public UserDAOImpl() {
        setClazz(User1.class);
    }

    @Override
    public User1 getUserByNameOrEmail(String userName, String email){
        return getUserByNameOrEmailHibernate(userName, email);
    }

}
