package com.bfs.backend.dao;

import com.bfs.backend.domain.RecruitingTesting;
import com.bfs.backend.domain.UserInternalPersonnel;

public interface UserInternalPersonnelDAO {
    UserInternalPersonnel getTest();
    RecruitingTesting getTestRecruiting();
}
