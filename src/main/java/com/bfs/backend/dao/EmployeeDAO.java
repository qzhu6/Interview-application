package com.bfs.backend.dao;

import com.bfs.backend.domain.Employee;

public interface EmployeeDAO {
    Employee getEmployeeByName(String FirstName, String LastName);
    Employee getEmployeeByUserID(int userID);
}
