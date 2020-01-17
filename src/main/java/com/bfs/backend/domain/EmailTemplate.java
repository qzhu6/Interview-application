package com.bfs.backend.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name="EmailTemplate", schema = "Recruiting")
public class EmailTemplate implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private Integer ID;
    public Integer getID() {
        return ID;
    }
    public void setID(Integer id) {
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
    @Column(name="CreateDate")
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
    private Integer CreateUser;
    public Integer getCreateUser() {
        return CreateUser;
    }
    public void setCreateUser(int createUser) {
        this.CreateUser = createUser;
    }

    @Column(name="ModifyUser")
    private Integer ModifyUser;
    public Integer getModifyUser() {
        return ModifyUser;
    }
    public void setModifyUser(Integer modifyUser) {
        this.ModifyUser = modifyUser;
    }

    @OneToMany(mappedBy = "emailTemplate", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<PotentialCandidate> potentialCandidateSet = new ArrayList<>();
    public List<PotentialCandidate> getPotentialCandidateSet() {
        return potentialCandidateSet;
    }
    public void GetPotentialCandidateSet(List<PotentialCandidate> potentialCandidateSet) {
        this.potentialCandidateSet = potentialCandidateSet;
    }

    public EmailTemplate(Integer ID, String EmailTemplateName, String EmailSubject, String EmailTemplateContent, Date CreateDate, Date ModifyDate, Integer CreateUser, Integer ModifyUser) {
        this.ID = ID;
        this.EmailTemplateName = EmailTemplateName;
        this.EmailSubject = EmailSubject;
        this.EmailTemplateContent = EmailTemplateContent;
        this.CreateDate = CreateDate;
        this.ModifyDate = ModifyDate;
        this.CreateUser = CreateUser;
        this.ModifyUser = ModifyUser;
    }

    public EmailTemplate(Integer ID, String EmailTemplateName){
        this.ID = ID;
        this.EmailTemplateName = EmailTemplateName;
    }

    public EmailTemplate(){

    }
}
