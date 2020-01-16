package com.bfs.backend.responseDomain;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class myCandidate implements java.io.Serializable{
    public myCandidate(){ }
    public myCandidate(int id, String firstName, String lastName, String email, String emailTemplateName,
                        String sentStatus, Date sentDate){
        this.ID=id;
        this.FirstName = firstName;
        this.LastName = lastName;
        this.Email = email;
        this.EmailTemplateName = emailTemplateName;
        this.SentStatus = sentStatus;
        this.SentDate = sentDate;
    }
    private int ID;
    private String FirstName;
    private String LastName;
    private String Email;
    private String EmailTemplateName;
    private String SentStatus;
    private Date SentDate;
}

