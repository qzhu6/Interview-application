package com.bfs.backend.dao.impl;

import com.bfs.backend.dao.AbstractHibernateDAO;
import com.bfs.backend.dao.PositionDAO;
import com.bfs.backend.domain.Position;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PositionDAOImpl extends AbstractHibernateDAO<Position> implements PositionDAO {

    public PositionDAOImpl(){
        this.setClazz(Position.class);
    }

    @Override
    public Position getPositionByName(String PositionName){
        Session session = getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Position> cq = cb.createQuery(Position.class);
        Root<Position> pRoot = cq.from(Position.class);
        cq.select(pRoot);
        cq.where(cb.equal(pRoot.get("PositionName"), PositionName));
        Position positionObject = session.createQuery(cq).getResultList().get(0);
        return positionObject;
    }

    @Override
    public List<String> listPosition(){
        Session session = getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Position> cq = cb.createQuery(Position.class);
        Root<Position> pRoot = cq.from(Position.class);
        cq.multiselect(
                pRoot.get("ID"),
                pRoot.get("PositionName"));
        List<Position> positionList = session.createQuery(cq).getResultList();
        List<String> positionStringList = new ArrayList<String>();
        for(Position x: positionList){
            positionStringList.add(x.getPositionName());
//            System.out.println(x.getID());
//            System.out.println(x.getPositionName());
        }
        return positionStringList;
    }
}
