package com.bfs.backend.service;

import com.bfs.backend.responseDomain.userInformation;

public interface UserService {
    userInformation getUserByName(String userName);
}