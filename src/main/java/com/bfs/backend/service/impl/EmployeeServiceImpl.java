package com.bfs.backend.service.impl;

import com.bfs.backend.dao.EmployeeDAO;
import com.bfs.backend.domain.Employee;
import com.bfs.backend.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeDAO employeeDAO;

    @Autowired
    public void setEmployeeDAO(EmployeeDAO employeeDAO){
        this.employeeDAO = employeeDAO;
    }

    @Override
    @Transactional
    public Employee getEmployee(String FirstName, String LastName){
        return this.employeeDAO.getEmployeeByName(FirstName, LastName);
    }

    @Override
    @Transactional
    public Employee getEmployeeByUserID(int userID){
        return employeeDAO.getEmployeeByUserID(userID);
    }
}
