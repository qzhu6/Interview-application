package com.bfs.backend.domain;

import java.util.ArrayList;
import java.util.Date;
import javax.persistence.*;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
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
@Table(name="`User`", schema = "Person")
public class User implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private int ID;

    @Column(name="UserName")
    private String UserName;

    @Column(name="Password")
    private String Password;

    @Column(name="InternalPersonnelID")
    private Integer InternalPersonnelID;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="CreateDate")
    private Date CreateDate;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="ModifyDate")
    private Date ModifyDate;



    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<UserRole> userRole = new HashSet<UserRole>();

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public Integer getInternalPersonnelID() {
        return InternalPersonnelID;
    }

    public void setInternalPersonnelID(Integer internalPersonnelID) {
        InternalPersonnelID = internalPersonnelID;
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

//    public InternalPersonnel getInternalPersonnel() {
//        return internalPersonnel;
//    }
//
//    public void setInternalPersonnel(InternalPersonnel internalPersonnel) {
//        this.internalPersonnel = internalPersonnel;
//    }
}
