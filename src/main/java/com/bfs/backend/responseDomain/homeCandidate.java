package com.bfs.backend.responseDomain;

import javax.persistence.Column;
import java.util.Date;

public class homeCandidate implements java.io.Serializable {
    public homeCandidate(){ }
    public homeCandidate(Date interviewStartDateTime, double interviewDuration, String firstName, String lastName, String interviewerName,
                         String cellPhone , String positionName,  String resumeFileLocation,
                         String resource){

        super();
        this.InterviewStartDateTime=interviewStartDateTime;
        this.InterviewDuration=interviewDuration;
        this.FirstName=firstName;
        this.LastName=lastName;
        this.InterviewerName=interviewerName;
        this.CellPhone=cellPhone;
        this.PositionName=positionName;
        this.ResumeFileLocation=resumeFileLocation;
        this.Resource=resource;
    }

    private Date InterviewStartDateTime;

    public Date getInterviewStartDateTime() {
        return InterviewStartDateTime;
    }

    public void setInterviewStartDateTime(Date interviewStartDateTime) {
        this.InterviewStartDateTime = interviewStartDateTime;
    }

    private double InterviewDuration;
    public double getInterviewDuration() {
        return InterviewDuration;
    }
    public void setInterviewDuration(double interviewDuration) {
        this.InterviewDuration = interviewDuration;
    }

    private String FirstName;
    public String getFirstName(){return FirstName;}
    public void setFirstName(String firstName){this.FirstName=firstName;}

    private String LastName;
    public String getLastName(){return LastName;}
    public void setLastName(String lastName){this.LastName=lastName;}

    private String InterviewerName;
    public String getInterviewerName() {
        return InterviewerName;
    }
    public void setInterviewerName(String interviewerName){
        this.InterviewerName = interviewerName;
    }

    private String CellPhone;
    public String getCellPhone(){return CellPhone;}
    public void setCellPhone(String cellPhone){this.CellPhone=cellPhone;}

    private String PositionName;
    public String getPositionName(){return PositionName;}
    public void setPositionName(String positionName){this.PositionName=positionName;}

    private String ResumeFileLocation;
    public String getResumeFileLocation(){return ResumeFileLocation;}
    public void setResumeFileLocation(String resumeFileLocation){this.ResumeFileLocation=resumeFileLocation;}

    private String Resource;
    public String getResource(){return Resource;}
    public void setResource(String resource){this.Resource=resource;}
}
