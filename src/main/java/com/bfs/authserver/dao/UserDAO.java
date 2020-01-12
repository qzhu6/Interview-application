package com.bfs.authserver.dao;


import com.bfs.authserver.domain.User1;

import java.util.List;

public interface UserDAO {
    User1 getUserByNameOrEmail(String str, String nameOrEmail);
}
