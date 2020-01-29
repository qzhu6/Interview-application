package com.bfs.backend.dao;

import com.bfs.backend.responseDomain.userInformation;

public interface UserDAO {
    userInformation findByUsername(String userName);

}
