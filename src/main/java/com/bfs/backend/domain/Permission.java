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
@Table(name="Permission", schema="Person")
public class Permission implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private int ID;

    @Column(name="PermissionName")
    private String PermissionName;

    @Column(name="Description")
    private String Description;

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
    private Integer ModifyUser;

    @OneToMany(mappedBy = "permission", cascade = CascadeType.ALL)
    private Set<RolePermission> rolePermission = new HashSet<RolePermission>();

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getPermissionName() {
        return PermissionName;
    }

    public void setPermissionName(String permissionName) {
        PermissionName = permissionName;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
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
