package com.bfs.backend.responseDomain;

import java.util.Date;

public class homeCandidate implements java.io.Serializable {
    public homeCandidate(){ }
    public homeCandidate(Date interviewStartDateTime, double interviewDuration, String firstName, String lastName, String interviewerFirstName, String interviewerLastName,
                         String cellPhone , String positionName,  String resumeFileLocation){

        this.InterviewStartDateTime=interviewStartDateTime;
        this.InterviewDuration=interviewDuration;
        this.FirstName=firstName;
        this.LastName=lastName;
        this.InterviewerFirstName = interviewerFirstName;
        this.InterviewerLastName=interviewerLastName;
        this.CellPhone=cellPhone;
        this.PositionName=positionName;
        this.ResumeFileLocation=resumeFileLocation;
    }

//    public homeCandidate( String firstName, String lastName, String ifirstName, String ilastName,
//                         String cellPhone , String positionName,  String resumeFileLocation){
////
////        super();
////        this.InterviewStartDateTime=interviewStartDateTime;
////        this.InterviewDuration=interviewDuration;
//        this.FirstName=firstName;
//        this.LastName=lastName;
//        this.InterviewerFirstName = InterviewerifirstName;
//        this.InterviewerLastName=lastName;
//        this.CellPhone=cellPhone;
//        this.PositionName=positionName;
//        this.ResumeFileLocation=resumeFileLocation;
//    }

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

    private String InterviewerFirstName;
    public String getInterviewerFirstName(){return InterviewerFirstName;}
    public void setInterviewerFirstName(String interviewerFirstName){this.InterviewerFirstName=interviewerFirstName;}

    private String FirstName;
    public String getFirstName(){return FirstName;}
    public void setFirstName(String firstName){this.FirstName=firstName;}

    private String LastName;
    public String getLastName(){return LastName;}
    public void setLastName(String lastName){this.LastName=lastName;}

    private String InterviewerLastName;
    public String getInterviewerLastName(){return InterviewerLastName;}
    public void setInterviewerLastName(String interviewerLastName){this.InterviewerLastName=interviewerLastName;}


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
