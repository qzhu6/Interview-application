package com.bfs.backend.service;

import com.bfs.backend.domain.RecruitingTesting;
import com.bfs.backend.domain.UserInternalPersonnel;

public interface UserInternalPersonnelService {
    UserInternalPersonnel getUserTest();
    RecruitingTesting getRecruiting();
}
