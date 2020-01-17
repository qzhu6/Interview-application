package com.bfs.backend.dao;

import com.bfs.backend.domain.Position;

import java.util.List;

public interface PositionDAO {
    Position getPositionByName(String PositionName);
    List<String> listPosition();
}
