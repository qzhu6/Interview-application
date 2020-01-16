package com.bfs.backend.dao;

import com.bfs.backend.domain.InterviewType;
import com.bfs.backend.domain.Position;

public interface InterviewTypeDAO {
    InterviewType getInterviewType(Position position, Integer Sequence);
}
