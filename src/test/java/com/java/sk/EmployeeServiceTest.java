package com.java.sk;

import com.java.sk.model.Employee;
import com.java.sk.repository.EmployeeRepository;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;
import com.java.sk.service.EmployeeService;
import com.java.sk.service.EmployeeServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTest {
    @Mock
    private EmployeeRepository employeeRepository;
    @InjectMocks
    private EmployeeServiceImpl employeeServiceImpl;
    private Employee employee;


    @BeforeEach
    void setUp()
    {
        employee=new Employee();
        employee.setEmpId(1L);
        employee.setEmpName("Sujeet Sharma");
        employee.setAge(40);
        employee.setMobileNo(9810968);
        employee.setAddress("New Delhi");
        employee.setEmailId("sujeet@gmail.com");
    }

    @Test
    void saveEmp_ShouldReturnSavedEmployee() {
        when(employeeRepository.save(employee)).thenReturn(employee);

        Employee savedEmployee = employeeServiceImpl.saveEmp(employee);

        assertEquals(employee.getEmpName(), savedEmployee.getEmpName());// expected , actual data
        assertEquals(40, savedEmployee.getAge());
        assertEquals("New Delhi", savedEmployee.getAddress());
        verify(employeeRepository, times(1)).save(employee);
    }
    @Test
    void getEmp_ShouldGetSavedEmployee()
    {
        when(employeeRepository.findById(1L)).thenReturn(Optional.of(employee));
        Optional<Employee> foundEmployee = employeeServiceImpl.getEmployee(1L);

        assertTrue(foundEmployee.isPresent());
        assertEquals("Sujeet Sharma",foundEmployee.get().getEmpName());
        verify(employeeRepository,times(1)).findById(1L);
    }
    @Test
    void getAllEmp_ShouldGetAllEmployees()
    {
        when(employeeRepository.findAll()).thenReturn(Arrays.asList(employee));

        List<Employee> allEmpDetails = employeeServiceImpl.getAllEmpDetails();

        assertEquals(1,allEmpDetails.size());
        verify(employeeRepository,times(1)).findAll();
    }
    @Test
    void updateEmployee_ShouldUpdateEmployeeDetails()
    {
        Employee updateEmpData=new Employee();
        updateEmpData.setEmpName("Sandeep Sharma");
        updateEmpData.setMobileNo(1111111);

        when(employeeRepository.findById(1L)).thenReturn(Optional.of(employee));
        when(employeeRepository.save(employee)).thenReturn(employee);

        Employee updateResult = employeeServiceImpl.updateEmp(1L, updateEmpData);

        assertEquals(employee.getEmpName(),updateResult.getEmpName());
        assertEquals(employee.getMobileNo(),updateResult.getMobileNo());
        verify(employeeRepository,times(1)).findById(1L);
        verify(employeeRepository,times(1)).save(employee);
    }
}
