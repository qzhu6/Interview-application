package com.bfs.backend.service;

import com.bfs.backend.domain.InterviewType;
import com.bfs.backend.domain.Position;

public interface InterviewTypeService {
    InterviewType getInterviewType(Position position, Integer Sequence);
}
