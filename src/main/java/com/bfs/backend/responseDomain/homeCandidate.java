package com.bfs.backend.responseDomain;

import javax.persistence.Column;
import java.util.Date;

public class homeCandidate implements java.io.Serializable {
    public homeCandidate(){ }
    public homeCandidate(Date interviewStartDateTime, double interviewDuration, String firstName, String lastName, String ifirstName, String ilastName,
                         String cellPhone , String positionName,  String resumeFileLocation){
//
//        super();
        this.InterviewStartDateTime=interviewStartDateTime;
        this.InterviewDuration=interviewDuration;
        this.FirstName=firstName;
        this.LastName=lastName;
        this.iFirstName = ifirstName;
        this.iLastName=ilastName;
        this.CellPhone=cellPhone;
        this.PositionName=positionName;
        this.ResumeFileLocation=resumeFileLocation;
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

    private String iFirstName;
    public String getiFirstName(){return iFirstName;}
    public void setiFirstName(String ifirstName){this.iFirstName=ifirstName;}

    private String FirstName;
    public String getFirstName(){return FirstName;}
    public void setFirstName(String firstName){this.FirstName=firstName;}

    private String LastName;
    public String getLastName(){return LastName;}
    public void setLastName(String lastName){this.LastName=lastName;}

    private String iLastName;
    public String getiLastName(){return iLastName;}
    public void setiLastName(String ilastName){this.iLastName=ilastName;}

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

}
