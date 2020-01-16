package com.bfs.backend.service.impl;

import com.bfs.backend.dao.PositionDAO;
import com.bfs.backend.domain.Position;
import com.bfs.backend.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PositionServiceImpl implements PositionService {
    private PositionDAO positionDAO;

    @Autowired
    public void setPositionDAO(PositionDAO positionDAO){
        this.positionDAO = positionDAO;
    }

    @Transactional
    @Override
    public Position getPositionObject(String PositionName){
        return positionDAO.getPositionByName(PositionName);
    }
}
