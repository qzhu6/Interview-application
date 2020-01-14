package com.bfs.backend.domain;

import java.util.ArrayList;
import java.util.Date;
import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name="Employee",schema="Person")
public class Employee implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private int ID;

    @Column(name="InternalPersonnelID")

    private int InternalPersonnelID;

    @Column(name="DepartmentID",insertable=false, updatable=false)
    private int DepartmentID;


    @Column(name="Title")
    private String Title;

    @Column(name="ManagerID")
    private int ManagerID;


    @Column(name="StartDate")
    private Date StartDate;

    @Column(name="EndDate")
    private Date EndDate;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="CreateDate")
    private Date CreateDate;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="ModifyDate")
    private Date ModifyDate;


    @Column(name="CreateUser")

    private int CreateUser;

    @Column(name="ModifyUser")
    private int ModifyUser;

    @OneToOne(mappedBy = "employee")
    private InternalPersonnel internalPersonnel;

    @ManyToOne
    @JoinColumn(name="DepartmentID", nullable=false)
    private Department department;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getInternalPersonnelID() {
        return InternalPersonnelID;
    }

    public void setInternalPersonnelID(int internalPersonnelID) {
        InternalPersonnelID = internalPersonnelID;
    }

    public int getDepartmentID() {
        return DepartmentID;
    }

    public void setDepartmentID(int departmentID) {
        DepartmentID = departmentID;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public int getManagerID() {
        return ManagerID;
    }

    public void setManagerID(int managerID) {
        ManagerID = managerID;
    }

    public Date getStartDate() {
        return StartDate;
    }

    public void setStartDate(Date startDate) {
        StartDate = startDate;
    }

    public Date getEndDate() {
        return EndDate;
    }

    public void setEndDate(Date endDate) {
        EndDate = endDate;
    }

    public Date getCreateDate() {
        return CreateDate;
    }

    public void setCreateDate(Date createDate) {
        CreateDate = createDate;
    }

    public Date getModifyDate() {
        return ModifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        ModifyDate = modifyDate;
    }

    public int getCreateUser() {
        return CreateUser;
    }

    public void setCreateUser(int createUser) {
        CreateUser = createUser;
    }

    public int getModifyUser() {
        return ModifyUser;
    }

    public void setModifyUser(int modifyUser) {
        ModifyUser = modifyUser;
    }

    public InternalPersonnel getInternalPersonnel() {
        return internalPersonnel;
    }

    public void setInternalPersonnel(InternalPersonnel internalPersonnel) {
        this.internalPersonnel = internalPersonnel;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @OneToMany(mappedBy = "interviewType")
    private Set<CandidateInterview> candidateInterviewSet = new HashSet<CandidateInterview>();
    public Set<CandidateInterview> getCandidateInterviewSet() {
        return candidateInterviewSet;
    }
    public void setCandidateInterviewSet(Set<CandidateInterview> candidateInterviewSet) {
        this.candidateInterviewSet = candidateInterviewSet;
    }

    @OneToMany(mappedBy = "employee")
    private Set<PotentialCandidate> potentialCandidateSet = new HashSet<PotentialCandidate>();
    public Set<PotentialCandidate> getPotentialCandidateSet() {
        return potentialCandidateSet;
    }
    public void GetPotentialCandidateSet(Set<PotentialCandidate> potentialCandidateSet) {
        this.potentialCandidateSet = potentialCandidateSet;
    }
}
