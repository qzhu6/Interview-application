package com.bfs.backend.domain;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Table(name="PotentialCandidate", schema = "Recruiting")
public class PotentialCandidate implements Serializable {
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

    @Column(name="FirstName")
    private String FirstName;

    public String getFirstName(){return FirstName;}

    public void setFirstName(String firstName){this.FirstName=firstName;}

    @Column(name="MiddleName")
    private String MiddleName;

    public String getMiddleName(){return MiddleName;}

    public void setMiddleName(String middleName){this.MiddleName=middleName;}

    @Column(name="LastName")
    private String LastName;

    public String getLastName(){return LastName;}

    public void setLastName(String lastName){this.LastName=lastName;}

    @Column(name="Email")
    private String Email;

    public String getEmail(){return Email;}

    public void setEmail(String email){this.Email=email;}

    @Column(name="CellPhone")
    private String CellPhone;

    public String getCellPhone(){return CellPhone;}

    public void setCellPhone(String cellPhone){this.CellPhone=cellPhone;}

    @Column(name="ResumeFileLocation")
    private String ResumeFileLocation;

    public String getResumeFileLocation(){return ResumeFileLocation;}

    public void setResumeFileLocation(String resumeFileLocation){this.ResumeFileLocation=resumeFileLocation;}


    @Column(name="SendStatusID")
    private int SendStatusID;

    public int getSendStatusID(){return SendStatusID;}

    public void setSendStatusID(int sendStatusID){this.SendStatusID = sendStatusID;}


    @Column(name="RecruiterEmployeeID")
    private int RecruiterEmployeeID;

    public int getRecruiterEmployeeID(){return RecruiterEmployeeID;}

    public void setRecruiterEmployeeID(int recruiterEmployeeID){this.RecruiterEmployeeID = recruiterEmployeeID;}

    @Column(name="PositionID")
    private int PositionID;

    public int getPositionID(){return PositionID;}

    public void setPositionID(int positionID){this.PositionID = positionID;}



    @Column(name="DefaultInterviewerEmployeeID")
    private int DefaultInterviewerEmployeeID;

    public int getDefaultInterviewerEmployeeID(){return DefaultInterviewerEmployeeID;}

    public void setDefaultInterviewerEmployeeID(int defaultInterviewerEmployeeID){this.DefaultInterviewerEmployeeID = defaultInterviewerEmployeeID;}


    @Column(name="Comments")
    private String Comments;

    public String getComments(){return Comments;}

    public void setComments(String comments){this.Comments=comments;}

    @Column(name="ReachoutFlag")
    private boolean ReachoutFlag;

    public boolean getReachoutFlag(){return ReachoutFlag;}

    public void setReachoutFlag(boolean reachoutFlag){this.ReachoutFlag=reachoutFlag;}

    @Column(name="ActiveFlag")
    private boolean ActiveFlag;

    public boolean getActiveFlag(){return ActiveFlag;}

    public void setActiveFlag(boolean activeFlag){this.ActiveFlag=activeFlag;}


    @Column(name="EmailTemplateID")
    private int EmailTemplateID;

    public int getEmailTemplateID() {
        return EmailTemplateID;
    }

    public void setEmailTemplateID(int emailTemplateID) {
        this.EmailTemplateID = emailTemplateID;
    }

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
