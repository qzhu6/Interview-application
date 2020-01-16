package com.bfs.backend.domain;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
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

    @ManyToOne
    @JoinColumn(name="SendStatusID",insertable=false, updatable=false)
    private SendStatus sendStatus;
    public SendStatus getSendStatus(){return sendStatus;}
    public void setSendStatus(SendStatus sendStatus){this.sendStatus = sendStatus;}


    @Column(name="RecruiterEmployeeID")
    private int RecruiterEmployeeID;

    @ManyToOne
    @JoinColumn(name="RecruiterEmployeeID",insertable=false, updatable=false)
    private Employee employee;
    public Employee getEmployee(){return employee;}
    public void setEmployee(Employee employee){this.employee = employee;}

    @Column(name="PositionID")
    private int PositionID;

    @ManyToOne
    @JoinColumn(name="PositionID",insertable=false, updatable=false)
    private Position position;
    public Position getPosition(){return position;}
    public void setPosition(Position position){this.position = position;}

//    @ManyToOne
//    @Column(name="DefaultInterviewerEmployeeID")
//    private int DefaultInterviewerEmployeeID;
//    public int getDefaultInterviewerEmployeeID(){return DefaultInterviewerEmployeeID;}
//    public void setDefaultInterviewerEmployeeID(int defaultInterviewerEmployeeID){this.DefaultInterviewerEmployeeID = defaultInterviewerEmployeeID;}


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

    @ManyToOne
    @JoinColumn(name="EmailTemplateID",insertable=false, updatable=false)
    private EmailTemplate emailTemplate;
    public EmailTemplate getEmailTemplate() {
        return emailTemplate;
    }
    public void setEmailTemplate(EmailTemplate emailTemplate) {
        this.emailTemplate = emailTemplate;
    }

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

    @OneToMany(mappedBy = "potentialCandidate")
    private Set<CandidateInterview> candidateInterviewSet = new HashSet<CandidateInterview>();
    public Set<CandidateInterview> getCandidateInterviewSet() {
        return candidateInterviewSet;
    }
    public void setCandidateInterviewSet(Set<CandidateInterview> candidateInterviewSet) {
        this.candidateInterviewSet = candidateInterviewSet;
    }

    @Column(name="Resource")
    private String Resource;
}
