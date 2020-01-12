package com.bfs.authserver.service.impl;

import com.bfs.authserver.dao.UserDAO;
import com.bfs.authserver.domain.User1;
import com.bfs.authserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private UserDAO userDAO;

    @Autowired
    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }


    @Transactional
    @Override
    public User1 getUserByNameOrEmail(String str, String nameOrEmail)
    {
        return userDAO.getUserByNameOrEmail(str, nameOrEmail);
    }
}
