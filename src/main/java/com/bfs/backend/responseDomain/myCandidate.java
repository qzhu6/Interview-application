package com.bfs.backend.responseDomain;


import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class myCandidate implements java.io.Serializable{
    public myCandidate(){ }

    private int ID;
    private String FirstName;
    private String LastName;
    private String Email;
    private String EmailTemplateName;
    private String SentStatus;
    private Date SentDate;

    public myCandidate(Integer ID, String firstName, String lastName, String email, String emailTemplateName, String sentStatus, Date sentDate) {
        this.ID = ID;
        FirstName = firstName;
        LastName = lastName;
        Email = email;
        EmailTemplateName = emailTemplateName;
        SentStatus = sentStatus;
        SentDate = sentDate;
    }




}
