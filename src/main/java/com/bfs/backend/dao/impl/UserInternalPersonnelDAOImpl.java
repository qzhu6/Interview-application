package com.bfs.backend.dao.impl;

import com.bfs.backend.dao.AbstractHibernateDAO;
import com.bfs.backend.dao.UserInternalPersonnelDAO;
import com.bfs.backend.domain.RecruitingTesting;
import com.bfs.backend.domain.UserInternalPersonnel;
import org.springframework.stereotype.Repository;

import java.text.ParseException;

@Repository("userInternalPersonnelDao")
public class UserInternalPersonnelDAOImpl extends AbstractHibernateDAO implements UserInternalPersonnelDAO {


    public UserInternalPersonnelDAOImpl() {
        setClazz(UserInternalPersonnel.class);
    }

    @Override
    public UserInternalPersonnel getTest() throws ParseException {
        return testSomeCandidate();
    }

    @Override
    public RecruitingTesting getTestRecruiting(){
        return testRecruiting();
    }
}
