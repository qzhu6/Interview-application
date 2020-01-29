package com.bfs.backend.dao.impl;


import com.bfs.backend.dao.AbstractHibernateDAO;
import com.bfs.backend.dao.UserDAO;
import com.bfs.backend.domain.User;
import com.bfs.backend.responseDomain.userInformation;
import org.hibernate.Session;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class UserDAOImpl extends AbstractHibernateDAO implements UserDAO {

    private static final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    public UserDAOImpl() {
        setClazz(userInformation.class);
    }

    @Override
    public userInformation findByUsername(String userName){
        Session session = getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<userInformation> cq = cb.createQuery(userInformation.class);
        Root<User> uRoot = cq.from(User.class);
        cq.multiselect(
                uRoot.get("UserName"),
                uRoot.get("Password"),
                uRoot.get("ID")
        );
        cq.where(
                cb.equal(uRoot.get("UserName"), userName)
        );
        List<userInformation> userInformationList =session.createQuery(cq).getResultList();
        if (userInformationList.isEmpty()){
            return null;
        }
        else{
            userInformation ui=userInformationList.get(0);
            ui.setPassword(passwordEncoder.encode(ui.getPassword()));
            return userInformationList.get(0);
        }



    }

}
