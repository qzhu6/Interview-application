//package com.bfs.backend.domain;
//
//import java.util.ArrayList;
//import java.util.Date;
//import javax.persistence.*;
//import java.io.Serializable;
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.time.LocalDate;
//import javax.persistence.Temporal;
//import javax.persistence.TemporalType;
//import org.hibernate.annotations.CreationTimestamp;
//import org.hibernate.annotations.UpdateTimestamp;
//
//@Entity
//@Table(name="Department",schema = "Person")
//public class Department implements Serializable{
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name="ID")
//    private int ID;
//
//    @Column(name="DepartmentName")
//    private String DepartmentName;
//
//    @CreationTimestamp
//    @Temporal(TemporalType.TIMESTAMP)
//    @Column(name="CreateDate")
//    private Date CreateDate;
//
//    @UpdateTimestamp
//    @Temporal(TemporalType.TIMESTAMP)
//    @Column(name="ModifyDate")
//    private Date ModifyDate;
//
//    @Column(name="CreateUser")
//
//    @Column(name="ModifyUser")
//}
