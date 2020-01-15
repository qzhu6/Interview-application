package com.bfs.backend.service.impl;

import com.bfs.backend.dao.UserInternalPersonnelDAO;
import com.bfs.backend.domain.RecruitingTesting;
import com.bfs.backend.domain.UserInternalPersonnel;
import com.bfs.backend.service.UserInternalPersonnelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;

@Service
public class UserInternalPersonnelServiceImpl implements UserInternalPersonnelService {
    private UserInternalPersonnelDAO userInternalPersonnelDao;

    @Autowired
    public void setUserInternalPersonnelDAO(UserInternalPersonnelDAO userInternalPersonnelDao) {
        this.userInternalPersonnelDao = userInternalPersonnelDao;
    }

    @Transactional
    @Override
    public UserInternalPersonnel getUserTest() throws ParseException {
        return userInternalPersonnelDao.getTest();
    }

    @Transactional
    @Override
    public RecruitingTesting getRecruiting(){
        return userInternalPersonnelDao.getTestRecruiting();
    }
}
