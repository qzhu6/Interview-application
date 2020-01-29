package com.bfs.backend.service;


import com.bfs.backend.responseDomain.Interview;
import java.util.List;

public interface InterviewService {
    List<List<Interview>> getListInterview(String PositionName);
//    List<Interview> getListInterviewByPositionName(String PositionName);
    void createNewInterview(Interview interview);
    List<String> getStringListPositionName();
    List<String> getEmployeeName();
    List<String> getCandidateName();
    void updateInterview(Interview interview);

}
