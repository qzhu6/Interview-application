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
@Table(name="InterviewType", schema = "Recruiting")
public class InterviewType implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private int ID;
//    public int getID() {
//        return ID;
//    }
//    public void setID(int id) {
//        this.ID = id;
//    }

    @Column(name="InterviewTypeName")
    private String InterviewTypeName;
//    public String getInterviewTypeName(){return InterviewTypeName;}
//    public void setInterviewTypeName(String interviewTypeName){this.InterviewTypeName=interviewTypeName;}

    @Column(name="InterviewTypeDescription")
    private String InterviewTypeDescription;
//    public String getInterviewTypeDescription(){return InterviewTypeDescription;}
//    public void setInterviewTypeDescription(String interviewTypeDescription){this.InterviewTypeDescription=interviewTypeDescription;}

    @Column(name="PositionID")
    private int PositionID;

    @ManyToOne
    @JoinColumn(name="PositionID",insertable=false, updatable=false)
    private InterviewType interviewType;
    public InterviewType getInterviewType(){return interviewType;}
    public void setInterviewType(InterviewType interviewType){this.interviewType = interviewType;}

    @Column(name="Sequence")
    private int Sequence;
//    public int getSequence(){return Sequence;}
//    public void setSequence(int sequence){this.Sequence = sequence;}

    @Column(name="DefaultInterviewerEmployeeID")
    private int DefaultInterviewerEmployeeID;
//    public int getDefaultInterviewerEmployeeID(){return DefaultInterviewerEmployeeID;}
//    public void setDefaultInterviewerEmployeeID(int defaultInterviewerEmployeeID){this.DefaultInterviewerEmployeeID = defaultInterviewerEmployeeID;}

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="CreateDate")
    private Date CreateDate;
//    public Date getCreateDate(){return CreateDate;}
//    public void setCreateDate(Date createDate){this.CreateDate=createDate;}

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="ModifyDate")
    private Date ModifyDate;
//    public Date getModifyDate() {
//        return ModifyDate;
//    }
//    public void setModifyDate(Date modifyDate) {
//        this.ModifyDate = modifyDate;
//    }

    @Column(name="CreateUser")
    private int CreateUser;
//    public int getCreateUser() {
//        return CreateUser;
//    }
//    public void setCreateUser(int createUser) {
//        this.CreateUser = createUser;
//    }

    @Column(name="ModifyUser")
    private Integer ModifyUser;
//    public int getModifyUser() {
//        return ModifyUser;
//    }
//    public void setModifyUser(int modifyUser) {
//        this.ModifyUser = modifyUser;
//    }

    @OneToMany(mappedBy = "employee")
    private Set<CandidateInterview> candidateInterviewSet = new HashSet<CandidateInterview>();
    public Set<CandidateInterview> getCandidateInterviewSet() {
        return candidateInterviewSet;
    }
    public void setCandidateInterviewSet(Set<CandidateInterview> candidateInterviewSet) {
        this.candidateInterviewSet = candidateInterviewSet;
    }

    public InterviewType(Integer ID, String InterviewTypeName, String InterviewTypeDescription, Integer PositionID, Integer Sequence, Integer DefaultInterviewerEmployeeID, Date CreateDate, Date ModifyDate, Integer CreateUser, Integer ModifyUser){

        this.ID = ID;
        this.InterviewTypeName = InterviewTypeName;
        this.InterviewTypeDescription = InterviewTypeDescription;
        this.PositionID = PositionID;
        this.Sequence = Sequence;
        this.DefaultInterviewerEmployeeID = DefaultInterviewerEmployeeID;
        this.CreateDate = CreateDate;
        this.ModifyDate = ModifyDate;
        this.CreateUser = CreateUser;
        if(ModifyUser == null) {
            this.ModifyUser = -1;
        }else{
            this.ModifyUser = ModifyUser;
        }
    }

    public InterviewType() {
    }
}
