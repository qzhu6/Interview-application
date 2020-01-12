package com.bfs.backend.service.impl;

import com.bfs.backend.dao.UserDAO;
import com.bfs.backend.domain.User1;
import com.bfs.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
