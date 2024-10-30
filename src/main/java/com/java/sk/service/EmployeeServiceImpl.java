package com.java.sk.service;

import com.java.sk.model.Employee;
import com.java.sk.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService{
    private EmployeeRepository employeeRepository;

    @Override
    public Employee saveEmp(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Optional<Employee> getEmployee(Long empId) {
        return employeeRepository.findById(empId);
    }

    @Override
    public List<Employee> getAllEmpDetails() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee updateEmp(Long empId, Employee employee) {
        Employee employeeData = employeeRepository.findById(empId).orElseThrow(() -> new RuntimeException("Not find employee."));
        employeeData.setAddress(employee.getAddress());
        employeeData.setAge(employee.getAge());
        employeeData.setEmpName(employee.getEmpName());
        employeeData.setEmailId(employee.getEmailId());
        employeeData.setMobileNo(employee.getMobileNo());
        return employeeRepository.save(employeeData);
    }

    @Override
    public void deleteEmp(Long empId) {
        employeeRepository.deleteById(empId);

    }
}
