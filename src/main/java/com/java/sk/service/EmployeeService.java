package com.java.sk.service;

import com.java.sk.model.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    Employee saveEmp(Employee employee);
    Optional<Employee> getEmployee(Long empId);
    List<Employee> getAllEmpDetails();
    Employee updateEmp(Long empId,Employee employee);
    void deleteEmp(Long empId);
}
