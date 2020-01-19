package com.bfs.backend.dao.impl;

import com.bfs.backend.dao.AbstractHibernateDAO;
import com.bfs.backend.dao.EmailTemplateDAO;
import com.bfs.backend.domain.EmailTemplate;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.validation.constraints.Email;
import java.util.ArrayList;
import java.util.List;

@Repository
public class EmailTemplateDAOImpl extends AbstractHibernateDAO<EmailTemplate> implements EmailTemplateDAO {
    @Override
    public List<String> listStringEmailTemplateName() {
        Session session = getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<EmailTemplate> cq = cb.createQuery(EmailTemplate.class);
        Root<EmailTemplate> etRoot = cq.from(EmailTemplate.class);
        cq.multiselect(
                etRoot.get("ID"),
                etRoot.get("EmailTemplateName")
        );
        List<EmailTemplate> listEmailTemplate = session.createQuery(cq).getResultList();
        List<String> listEmailTemplateName = new ArrayList<String>();
        for(EmailTemplate x: listEmailTemplate){
            listEmailTemplateName.add(x.getEmailTemplateName());
        }
        return listEmailTemplateName;
    }

    @Override
    public List<EmailTemplate> listEmailTemplate() {
        Session session = getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<EmailTemplate> cq = cb.createQuery(EmailTemplate.class);
        Root<EmailTemplate> etRoot = cq.from(EmailTemplate.class);
        cq.select(etRoot);
        return session.createQuery(cq).getResultList();
    }

    @Override
    public void createEmailTemplate(EmailTemplate emailTemplate){
        Session session = getCurrentSession();
        EmailTemplate newEmailTemplate = new EmailTemplate();
        newEmailTemplate.setEmailTemplateName(emailTemplate.getEmailTemplateName());
        newEmailTemplate.setEmailSubject(emailTemplate.getEmailSubject());
        newEmailTemplate.setEmailTemplateContent(emailTemplate.getEmailTemplateContent());
        session.persist(newEmailTemplate);
    }

    @Override
    public EmailTemplate lookUpEmailTemplate(String EmailTemplateName){
        Session session = getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<EmailTemplate> cq = cb.createQuery(EmailTemplate.class);
        Root<EmailTemplate> etRoot = cq.from(EmailTemplate.class);
        cq.select(etRoot);
        cq.where(
                cb.equal(etRoot.get("EmailTemplateName"), EmailTemplateName)
        );
        return session.createQuery(cq).getSingleResult();
    }


}
