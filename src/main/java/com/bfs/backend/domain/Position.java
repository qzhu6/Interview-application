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
@Table(name="Position", schema = "Recruiting")
public class Position implements Serializable {
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

    @Column(name="PositionName")
    private String PositionName;
    public String getPositionName(){return PositionName;}
    public void setPositionName(String positionName){this.PositionName=positionName;}

    @Column(name="Description")
    private String Description;
    public String getDescription(){return Description;}
    public void setDescription(String description){this.Description=description;}


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
    private Integer ModifyUser;
    public Integer getModifyUser() {
        return ModifyUser;
    }
    public void setModifyUser(Integer modifyUser) {
        this.ModifyUser = modifyUser;
    }

    @OneToMany(mappedBy = "position")
    private Set<PotentialCandidate> potentialCandidateSet = new HashSet<PotentialCandidate>();
    public Set<PotentialCandidate> getPotentialCandidateSet() {
        return potentialCandidateSet;
    }
    public void GetPotentialCandidateSet(Set<PotentialCandidate> potentialCandidateSet) {
        this.potentialCandidateSet = potentialCandidateSet;
    }

    public Position() {
    }

    public Position(Integer ID, String PositionName, String Description, Date CreateDate, Date ModifyDate, Integer CreateUser, Integer ModifyUser) {
        this.ID = ID;
        this.PositionName = PositionName;
        this.Description = Description;
        this.CreateDate = CreateDate;
        this.ModifyDate = ModifyDate;
        this.CreateUser = CreateUser;
        if(ModifyUser == null){
            this.ModifyUser = -1;
        }
        else{
            this.ModifyUser = ModifyUser;
        }
    }


}
