package com.bfs.backend.responseDomain;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class allCandidate implements java.io.Serializable{
    public allCandidate(){ }

    public allCandidate(int id, String firstName,  String lastName, String email, String cellPhone
            , String positionName, String emailTemplateName, String employeeFirstName, String employeeLastName,
                        Date createDate, String resource, String comment,  String resumeFileLocation, int createUser){
        this.ID=id;
        this.FirstName = firstName;
        this.LastName = lastName;
        this.Email = email;
        this.CellPhone = cellPhone;
        this.PositionName = positionName;
        this.EmailTemplateName = emailTemplateName;
        this.EmployeeFirstName = employeeFirstName;
        this.EmployeeLastName = employeeLastName;
        this.CreateDate = createDate;
        this.Resource = resource;
        this.Comment = comment;
        this.ResumeFileLocation = resumeFileLocation;
        this.IsBelongtoMe = false;
        this.CreateUser = createUser;
    }

    private int CreateUser;
    private int ID;
    private String FirstName;
    private String LastName;
    private String Email;
    private String CellPhone;
    private String PositionName;
    private String EmailTemplateName;
    private String EmployeeFirstName;
    private String EmployeeLastName;
    private Date CreateDate;
    private String Resource;
    private String Comment;
    private String ResumeFileLocation;
    private Boolean IsBelongtoMe;
}
