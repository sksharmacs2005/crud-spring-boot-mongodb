package com.java.sk.repository;

import com.java.sk.model.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EmployeeRepository extends MongoRepository<Employee,Long> {
    //String searchEmailId(String email);
}
