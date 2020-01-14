package com.bfs.backend.service;

import com.bfs.backend.domain.User1;

public interface UserService {
    User1 getUserByNameOrEmail(String str, String nameOrEmail);
    void testSomeCandidate();
}