package com.bfs.backend.service;

import com.bfs.backend.domain.Employee;

public interface EmployeeService {
    Employee getEmployee(String FirstName, String LastName);
    Employee getEmployeeByUserID(int userID);
}
