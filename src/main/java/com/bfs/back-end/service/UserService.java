package com.bfs.authserver.service;

import com.bfs.authserver.domain.User1;

import java.util.List;

public interface UserService {
    User1 getUserByNameOrEmail(String str, String nameOrEmail);
}