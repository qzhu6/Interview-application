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
import org.springframework.stereotype.Service;


@Entity
@Table(name="RolePermission", schema="Person")
public class RolePermission implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private int ID;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="RoleID")
    private Role role;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="PermissionID")
    private Permission permission;

    @Column(name="ActiveFlag")
    private boolean ActiveFlag;

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

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Permission getPermission() {
        return permission;
    }

    public void setPermission(Permission permission) {
        this.permission = permission;
    }

    public boolean isActiveFlag() {
        return ActiveFlag;
    }

    public void setActiveFlag(boolean activeFlag) {
        ActiveFlag = activeFlag;
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
}
