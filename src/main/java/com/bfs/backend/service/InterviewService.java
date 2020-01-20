package com.bfs.backend.service;

import com.bfs.backend.domain.Employee;
import com.bfs.backend.domain.InterviewType;
import com.bfs.backend.domain.Position;
import com.bfs.backend.domain.PotentialCandidate;
import com.bfs.backend.responseDomain.Interview;

import java.util.List;
import java.util.Set;

public interface InterviewService {
    List<List<Interview>> getListInterview(String PositionName);
    List<Interview> getListInterviewByPositionName(String PositionName);
    void createNewInterview(Interview interview);
    List<String> getStringListPositionName();
    List<String> getEmployeeName();
    List<String> getCandidateName();
    void updateInterview(Interview interview);

}
