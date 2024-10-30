package com.java.sk.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Document(collection = "empinfo")
public class Employee {
    @Id
    private Long empId;
    private String empName;
    private int age;
    private String address;
    private Integer mobileNo;
    private String emailId;
}
