package com.java.sk.controller;

import com.java.sk.model.Employee;
import com.java.sk.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emp")
@AllArgsConstructor
public class EmployeeController {
    private EmployeeService employeeService;

    @PostMapping("/save")
    public Employee saveEmployeeDetails(@RequestBody Employee employee)
    {
        return employeeService.saveEmp(employee);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeDetail(@PathVariable("id") Long empId)
    {
        Employee employee = employeeService.getEmployee(empId).orElseThrow(() -> new RuntimeException("Employee details not exit."));
        return ResponseEntity.ok(employee);
    }
    @GetMapping("/allEmp")
    public List<Employee> getAllEmp()
    {
        return employeeService.getAllEmpDetails();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable("id") Long empId,@RequestBody Employee employee)
    {
        Employee employeeUpdate = employeeService.updateEmp(empId, employee);
        return ResponseEntity.ok(employeeUpdate);

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmp(@PathVariable("id") Long empId)
    {
        employeeService.deleteEmp(empId);
        return ResponseEntity.noContent().build();
    }

}
