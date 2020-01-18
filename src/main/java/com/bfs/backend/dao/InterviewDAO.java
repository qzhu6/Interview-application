package com.bfs.backend.dao;

import com.bfs.backend.domain.Employee;
import com.bfs.backend.domain.InterviewType;
import com.bfs.backend.domain.Position;
import com.bfs.backend.domain.PotentialCandidate;
import com.bfs.backend.responseDomain.Interview;

import java.util.List;
import java.util.Set;

public interface InterviewDAO {
    List<Interview> getInterview(String PositionName);
    List<Interview> getInterviewByPositionName(String PositionName);
    void createInterview(Interview interview, PotentialCandidate potentialCandidate, Employee employee, InterviewType interviewType);
}
