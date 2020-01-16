package com.bfs.backend.dao;

import com.bfs.backend.domain.Position;

public interface PositionDAO {
    Position getPositionByName(String PositionName);
}
