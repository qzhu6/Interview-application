package com.bfs.authserver.dao.impl;


import com.bfs.authserver.dao.AbstractHibernateDAO;
import com.bfs.authserver.dao.UserDAO;
import com.bfs.authserver.domain.User1;
import org.springframework.stereotype.Repository;

import java.util.List;

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
