package com.bfs.backend.service;

import com.bfs.backend.domain.RecruitingTesting;
import com.bfs.backend.domain.UserInternalPersonnel;

import java.text.ParseException;

public interface UserInternalPersonnelService {
    UserInternalPersonnel getUserTest() throws ParseException;
    RecruitingTesting getRecruiting();
}
