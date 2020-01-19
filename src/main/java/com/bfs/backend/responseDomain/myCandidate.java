package com.bfs.backend.responseDomain;

<<<<<<< HEAD
import java.io.Serializable;
import java.util.Date;

public class myCandidate implements Serializable {
    private Integer ID;
=======
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
>>>>>>> 66cec75f5ecd509d19605965016ec5c73c6551b6
    private String FirstName;
    private String LastName;
    private String Email;
    private String EmailTemplateName;
    private String SentStatus;
    private Date SentDate;
<<<<<<< HEAD

    public myCandidate(Integer ID, String firstName, String lastName, String email, String emailTemplateName, String sentStatus, Date sentDate) {
        this.ID = ID;
        FirstName = firstName;
        LastName = lastName;
        Email = email;
        EmailTemplateName = emailTemplateName;
        SentStatus = sentStatus;
        SentDate = sentDate;
    }

    public myCandidate() {
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
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

    public String getEmailTemplateName() {
        return EmailTemplateName;
    }

    public void setEmailTemplateName(String emailTemplateName) {
        EmailTemplateName = emailTemplateName;
    }

    public String getSentStatus() {
        return SentStatus;
    }

    public void setSentStatus(String sentStatus) {
        SentStatus = sentStatus;
    }

    public Date getSentDate() {
        return SentDate;
    }

    public void setSentDate(Date sentDate) {
        SentDate = sentDate;
    }
}
=======
}

>>>>>>> 66cec75f5ecd509d19605965016ec5c73c6551b6
