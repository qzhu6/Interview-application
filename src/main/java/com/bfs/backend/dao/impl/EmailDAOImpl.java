package com.bfs.backend.dao.impl;

import com.bfs.backend.dao.AbstractHibernateDAO;
import com.bfs.backend.dao.EmailDAO;
import com.bfs.backend.dao.EmployeeDAO;
import com.bfs.backend.domain.EmailTemplate;
import com.bfs.backend.domain.Employee;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

@Repository
public class EmailDAOImpl extends AbstractHibernateDAO implements EmailDAO {
    public EmailDAOImpl(){
        this.setClazz(EmailTemplate.class);
    }

    @Override
    public EmailTemplate getEmailByName(String EmailTemplateName){
        Session session = getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<EmailTemplate> cq = cb.createQuery(EmailTemplate.class);
        Root<EmailTemplate> eRoot = cq.from(EmailTemplate.class);
        cq.select(eRoot);
        cq.where(
                cb.equal(eRoot.get("EmailTemplateName"), EmailTemplateName)
        );
        EmailTemplate email = session.createQuery(cq).getResultList().get(0);
        return email;
    }
}
