package com.bfs.backend.domain;


import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="EmailTemplate", schema = "Recruiting")
public class EmailTemplate implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private int ID;

    public int getID() {
        return ID;
    }

    public void setID(int id) {
        this.ID = id;
    }

    @Column(name="EmailTemplateName")
    private String EmailTemplateName;

    public String getEmailTemplateName(){return EmailTemplateName;}

    public void setEmailTemplateName(String emailTemplateName){this.EmailTemplateName=emailTemplateName;}

    @Column(name="EmailSubject")
    private String EmailSubject;

    public String getEmailSubject(){return EmailSubject;}

    public void setEmailSubject(String emailSubject){this.EmailSubject=emailSubject;}

    @Column(name="EmailTemplateContent")
    private String EmailTemplateContent;

    public String getEmailTemplateContent(){return EmailTemplateContent;}

    public void setEmailTemplateContent(String emailTemplateContent){this.EmailTemplateContent = emailTemplateContent;}

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="CreatedDate")
    private Date CreateDate;

    public Date getCreateDate(){return CreateDate;}

    public void setCreateDate(Date createDate){this.CreateDate=createDate;}

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="ModifyDate")
    private Date ModifyDate;
    public Date getModifyDate() {
        return ModifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.ModifyDate = modifyDate;
    }

    @Column(name="CreateUser")
    private int CreateUser;

    public int getCreateUser() {
        return CreateUser;
    }

    public void setCreateUser(int createUser) {
        this.CreateUser = createUser;
    }

    @Column(name="ModifyUser")
    private int ModifyUser;

    public int getModifyUser() {
        return ModifyUser;
    }

    public void setModifyUser(int modifyUser) {
        this.ModifyUser = modifyUser;
    }
}
