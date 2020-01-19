package com.bfs.backend.domain;

import java.util.ArrayList;
import java.util.Date;
import javax.persistence.*;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name="InternalPersonnel", schema = "Person")
public class InternalPersonnel implements Serializable{
    public InternalPersonnel(){

    }
    public InternalPersonnel(String FirstName, String LastName) {
        this.FirstName=FirstName;
        this.LastName=LastName;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private int ID;

    @Column(name="FirstName")
    private String FirstName;

    @Column(name="MiddleName")
    private String MiddleName;

    @Column(name="LastName")
    private String LastName;

    @Column(name="Email")
    private String Email;

    @Column(name="CellPhone")
    private String CellPhone;

    @Column(name="SSN")
    private String SSN;

    @Column(name="DOB")
    private Date DOB;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="CreateDate")
    private Date CreateDate;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="ModifyDate")
    private Date ModifyDate;

//    @OneToOne
//    @JoinColumn(name="ID")
//    private User user;

    @OneToOne
    @JoinColumn(name="ID")
    private Role role;

    @OneToOne
    @JoinColumn(name="ID")
    private Employee employee;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getMiddleName() {
        return MiddleName;
    }

    public void setMiddleName(String middleName) {
        MiddleName = middleName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getCellPhone() {
        return CellPhone;
    }

    public void setCellPhone(String cellPhone) {
        CellPhone = cellPhone;
    }

    public String getSSN() {
        return SSN;
    }

    public void setSSN(String SSN) {
        this.SSN = SSN;
    }

    public Date getDOB() {
        return DOB;
    }

    public void setDOB(Date DOB) {
        this.DOB = DOB;
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

//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
