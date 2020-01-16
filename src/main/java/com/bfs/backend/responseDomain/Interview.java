package com.bfs.backend.responseDomain;

import java.io.Serializable;
import java.util.Date;

public class Interview implements Serializable {
    private int ID;
    private Date InterviewStartDateTime;
    private double InterviewDuration;
    private String PositionName;
    private String IntervieweeFirstName;
    private String IntervieweeLastName;
    private double OverallRating;
    private String InterviewerFirstName;
    private String InterviewerMiddleName;
    private String InterviewerLastName;
    private String Comment;
    private String ResumeFileLocation;
    private int Sequence;
    private String InterviewStatus;
    private String IntervieweeFullName;

    public Interview(int ID, Date interviewStartDateTime, double interviewDuration, String positionName, String intervieweeFirstName, String intervieweeLastName, double overallRating, String interviewerFirstName, String interviewerMiddleName, String interviewerLastName, String comment, String resumeFileLocation, int sequence, String interviewStatus) {
        this.ID = ID;
        InterviewStartDateTime = interviewStartDateTime;
        InterviewDuration = interviewDuration;
        PositionName = positionName;
        IntervieweeFirstName = intervieweeFirstName;
        IntervieweeLastName = intervieweeLastName;
        OverallRating = overallRating;
        InterviewerFirstName = interviewerFirstName;
        if(interviewerMiddleName == null){
            InterviewerMiddleName = "";
        }
        else {
            InterviewerMiddleName = interviewerMiddleName;
        }
        InterviewerLastName = interviewerLastName;
        Comment = comment;
        ResumeFileLocation = resumeFileLocation;
        Sequence = sequence;
        InterviewStatus = interviewStatus;
        this.setIntervieweeFullName();
    }

    public Interview() {
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public Date getInterviewStartDateTime() {
        return InterviewStartDateTime;
    }

    public void setInterviewStartDateTime(Date interviewStartDateTime) {
        InterviewStartDateTime = interviewStartDateTime;
    }

    public double getInterviewDuration() {
        return InterviewDuration;
    }

    public void setInterviewDuration(double interviewDuration) {
        InterviewDuration = interviewDuration;
    }

    public String getPositionName() {
        return PositionName;
    }

    public void setPositionName(String positionName) {
        PositionName = positionName;
    }

    public String getIntervieweeFirstName() {
        return IntervieweeFirstName;
    }

    public void setIntervieweeFirstName(String intervieweeFirstName) {
        IntervieweeFirstName = intervieweeFirstName;
    }

    public String getIntervieweeLastName() {
        return IntervieweeLastName;
    }

    public void setIntervieweeLastName(String intervieweeLastName) {
        IntervieweeLastName = intervieweeLastName;
    }

    public double getOverallRating() {
        return OverallRating;
    }

    public void setOverallRating(double overallRating) {
        OverallRating = overallRating;
    }

    public String getInterviewerFirstName() {
        return InterviewerFirstName;
    }

    public void setInterviewerFirstName(String interviewerFirstName) {
        InterviewerFirstName = interviewerFirstName;
    }

    public String getInterviewerMiddleName() {
        return InterviewerMiddleName;
    }

    public void setInterviewerMiddleName(String interviewerMiddleName) {
        InterviewerMiddleName = interviewerMiddleName;
    }

    public String getInterviewerLastName() {
        return InterviewerLastName;
    }

    public void setInterviewerLastName(String interviewerLastName) {
        InterviewerLastName = interviewerLastName;
    }

    public String getComment() {
        return Comment;
    }

    public void setComment(String comment) {
        Comment = comment;
    }

    public String getResumeFileLocation() {
        return ResumeFileLocation;
    }

    public void setResumeFileLocation(String resumeFileLocation) {
        ResumeFileLocation = resumeFileLocation;
    }

    public int getSequence() {
        return Sequence;
    }

    public void setSequence(int sequence) {
        Sequence = sequence;
    }

    public String getInterviewStatus() {
        return InterviewStatus;
    }

    public void setInterviewStatus(String interviewStatus) {
        InterviewStatus = interviewStatus;
    }

    public String getIntervieweeFullName() {
        return IntervieweeFullName;
    }

    public void setIntervieweeFullName() {
        IntervieweeFullName = IntervieweeFirstName + " " + IntervieweeLastName;
    }
}
