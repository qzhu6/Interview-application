package com.bfs.backend.dao;


import com.bfs.backend.domain.User1;

public interface UserDAO {
    User1 getUserByNameOrEmail(String str, String nameOrEmail);
}
