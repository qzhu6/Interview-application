package com.bfs.backend.service.impl;

import com.bfs.backend.dao.InterviewDAO;
import com.bfs.backend.responseDomain.Interview;
import com.bfs.backend.service.InterviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Comparator;
import java.util.stream.Collectors;

import java.util.List;

@Service
public class InterviewServiceImpl implements InterviewService {
    private InterviewDAO interviewDao;

    @Autowired
    public void setInterviewDao(InterviewDAO interviewDao){
        this.interviewDao = interviewDao;
    }

    @Transactional
    @Override
    public List<Interview> getListInterview(){
//        List<Interview> interview = interviewDao.getInterview();
//        Comparator<Interview> compareByName = Comparator.comparing(Interview::getIntervieweeFullName).thenComparing(Interview::getPositionName).thenComparing(Interview::getSequence);
//        List<Interview> sortedInterview = interview.stream().sorted(compareByName).collect(Collectors.toList());
        return interviewDao.getInterview();
    }
}
