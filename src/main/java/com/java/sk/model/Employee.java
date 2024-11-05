package com.java.sk.model;

import lombok.*;
import org.springframework.data.annotation.Id;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Employee {
    @Id
    private Long empId;
    private String empName;
    private int age;
    private String address;
    private Integer mobileNo;
    private String emailId;
}
