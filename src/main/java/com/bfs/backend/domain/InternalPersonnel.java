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

@Entity
@Table(name="InternalPersonnel", schema = "Person")
public class InternalPersonnel implements Serializable{

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
}
