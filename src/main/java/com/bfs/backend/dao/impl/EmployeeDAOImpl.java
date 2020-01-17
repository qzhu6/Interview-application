package com.bfs.backend.dao.impl;

import com.bfs.backend.dao.AbstractHibernateDAO;
import com.bfs.backend.dao.EmployeeDAO;
import com.bfs.backend.domain.Employee;
import com.bfs.backend.domain.InternalPersonnel;
import com.bfs.backend.domain.User;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class EmployeeDAOImpl extends AbstractHibernateDAO<Employee> implements EmployeeDAO {

    public EmployeeDAOImpl(){
        this.setClazz(Employee.class);
    }

    @Override
    public Employee getEmployeeByName(String FirstName, String LastName){
//        System.out.println(FirstName);
//        System.out.println(LastName);
//        return null;
        Session session = getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Employee> cq = cb.createQuery(Employee.class);
        Root<Employee> eRoot = cq.from(Employee.class);
        Root<InternalPersonnel> ipRoot = cq.from(InternalPersonnel.class);
        cq.select(eRoot);
        cq.where(
                cb.equal(ipRoot.get("FirstName"), FirstName),
                cb.equal(ipRoot.get("LastName"), LastName),
                cb.equal(ipRoot.get("ID"), eRoot.get("InternalPersonnelID"))
        );
        Employee employee = session.createQuery(cq).getResultList().get(0);
//        List<Employee> employee = session.createQuery(cq).getResultList();
//        for(Employee e: employee){
//            System.out.println("Hi");
//        }
        return employee;
    }

    @Override
    public Employee getEmployeeByUserID(int userID){
        Session session = getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Employee> cq = cb.createQuery(Employee.class);
        Root<Employee> eRoot = cq.from(Employee.class);
        Root<InternalPersonnel> ipRoot = cq.from(InternalPersonnel.class);
        Root<User> uRoot = cq.from(User.class);
        cq.select(eRoot);
        cq.where(
                cb.equal(ipRoot.get("ID"), eRoot.get("InternalPersonnelID")),
                cb.equal(ipRoot.get("ID"), uRoot.get("InternalPersonnelID")),
                cb.equal(uRoot.get("ID"), userID)
        );
        Employee employee = session.createQuery(cq).getResultList().get(0);
        return employee;
    }
}
