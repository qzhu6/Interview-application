package com.bfs.backend.domain;

public class RecruitingTesting {
    private String PositionName;
    private String SendDescription;
    private String EmailSubject;
    private String Email;
    private String InterviewTypeDescription;

    public RecruitingTesting(){

    }

    public RecruitingTesting(String PositionName, String SendDescription, String EmailSubject, String Email, String InterviewTypeDescription)
    {
        this.setPositionName(PositionName);
        this.setSendDescription(SendDescription);
        this.setEmailSubject(EmailSubject);
        this.setEmail(Email);
        this.setInterviewTypeDescription(InterviewTypeDescription);
    }

    public String getPositionName() {
        return PositionName;
    }

    public void setPositionName(String positionName) {
        PositionName = positionName;
    }

    public String getSendDescription() {
        return SendDescription;
    }

    public void setSendDescription(String SendDescription) {
        this.SendDescription = SendDescription;
    }

    public String getEmailSubject() {
        return EmailSubject;
    }

    public void setEmailSubject(String emailSubject) {
        EmailSubject = emailSubject;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getInterviewTypeDescription() {
        return InterviewTypeDescription;
    }

    public void setInterviewTypeDescription(String interviewTypeDescription) {
        InterviewTypeDescription = interviewTypeDescription;
    }
}
