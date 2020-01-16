package com.bfs.backend.domain;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name="CandidateInterview", schema = "Recruiting")
public class CandidateInterview implements Serializable {
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


    @ManyToOne
    @JoinColumn(name="PotentialCandidateID",insertable=false, updatable=false)
    private PotentialCandidate potentialCandidate;
    public PotentialCandidate getPotentialCandidate() {
        return potentialCandidate;
    }
    public void setPotentialCandidate(PotentialCandidate potentialCandidate) {
        this.potentialCandidate = potentialCandidate;
    }

    @ManyToOne
    @JoinColumn(name="InterviewTypeID",insertable=false, updatable=false)
    private InterviewType interviewType;
    public InterviewType getInterviewType() {
        return interviewType;
    }
    public void setInterviewType(InterviewType interviewType) {
        this.interviewType = interviewType;
    }

    @ManyToOne
    @JoinColumn(name="InterviewerEmplID",insertable=false, updatable=false)
    private Employee employee;
    public Employee getInterviewEmplID() {
        return employee;
    }
    public void setInterviewEmplID(Employee employee) {
        this.employee = employee;
    }

    @Column(name="PotentialCandidateID")
    private int PotentialCandidateID;
    public int getPotentialCandidateID() {
        return PotentialCandidateID;
    }
    public void setPotentialCandidateID(int potentialCandidateID) {
        PotentialCandidateID = potentialCandidateID;
    }

    @Column(name="InterviewTypeID")
    private int InterviewTypeID;
    public int getInterviewTypeID() {
        return InterviewTypeID;
    }
    public void setInterviewTypeID(int interviewTypeID) {
        InterviewTypeID = interviewTypeID;
    }

    @Column(name="InterviewerEmplID")
    private int InterviewerEmplID;
    public int getInteviewerEmplID() {
        return InterviewerEmplID;
    }
    public void setInteviewerEmplID(int inteviewerEmplID) {
        InterviewerEmplID = inteviewerEmplID;
    }

    @Column(name="OverallRating")
    private double OverallRating;
    public double getOverallRating() {
        return OverallRating;
    }
    public void setOverallRating(double overallRating) {
        this.OverallRating = overallRating;
    }

    @Column(name="Comments")
    private String Comments;
    public String getComments() {
        return Comments;
    }
    public void setComments(String comments) {
        this.Comments = comments;
    }

    @Column(name="InterviewStartDateTime")
    private Date InterviewStartDateTime;
    public Date getInterviewStartDateTime() {
        return InterviewStartDateTime;
    }
    public void setInterviewStartDateTime(Date interviewStartDateTime) {
        this.InterviewStartDateTime = interviewStartDateTime;
    }

    @Column(name="InterviewDuration")
    private double InterviewDuration;
    public double getInterviewDuration() {
        return InterviewDuration;
    }
    public void setInterviewDuration(double interviewDuration) {
        this.InterviewDuration = interviewDuration;
    }

    @Column(name="InterviewEndDateTime")
    private Date InterviewEndDateTime;
    public Date getInterviewEndDateTime() {
        return InterviewEndDateTime;
    }
    public void setInterviewEndDateTime(Date interviewEndDateTime) {
        this.InterviewEndDateTime = interviewEndDateTime;
    }

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="CreateDate")
    private Date CreateDate;
    public Date getCreateDate() {
        return CreateDate;
    }
    public void setCreateDate(Date createDate) {
        this.CreateDate = createDate;
    }

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

    @Column(name="InterviewStatus")
    private String InterviewStatus;

    public String getInterviewStatus() {
        return InterviewStatus;
    }

    public void setInterviewStatus(String interviewStatus) {
        InterviewStatus = interviewStatus;
    }
}
