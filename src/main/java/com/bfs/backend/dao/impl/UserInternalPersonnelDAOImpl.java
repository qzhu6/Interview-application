package com.bfs.backend.dao.impl;

import com.bfs.backend.dao.AbstractHibernateDAO;
import com.bfs.backend.dao.UserInternalPersonnelDAO;
import com.bfs.backend.domain.UserInternalPersonnel;
import org.springframework.stereotype.Repository;

@Repository("userInternalPersonnelDao")
public class UserInternalPersonnelDAOImpl extends AbstractHibernateDAO implements UserInternalPersonnelDAO {


    public UserInternalPersonnelDAOImpl() {
        setClazz(UserInternalPersonnel.class);
    }

    @Override
    public UserInternalPersonnel getTest(){
        return getSomething();
    }
}
