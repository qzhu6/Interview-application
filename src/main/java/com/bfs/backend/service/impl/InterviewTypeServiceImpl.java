package com.bfs.backend.service.impl;

import com.bfs.backend.dao.InterviewTypeDAO;
import com.bfs.backend.domain.InterviewType;
import com.bfs.backend.domain.Position;
import com.bfs.backend.service.InterviewTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class InterviewTypeServiceImpl implements InterviewTypeService {
    private InterviewTypeDAO interviewTypeDAO;

    @Autowired
    public void setInterviewTypeDAO(InterviewTypeDAO interviewTypeDAO){
        this.interviewTypeDAO = interviewTypeDAO;
    }

    @Override
    @Transactional
    public InterviewType getInterviewType(Position position, Integer Sequence){
        return this.interviewTypeDAO.getInterviewType(position, Sequence);
    }


}
