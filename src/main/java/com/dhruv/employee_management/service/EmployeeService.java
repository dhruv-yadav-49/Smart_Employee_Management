package com.dhruv.employee_management.service;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    public EmployeeService() {
        System.out.println("EmployeeService Constructor Executed");
    }

    @PostConstruct
    public void init() {
        System.out.println("EmployeeService @PostConstruct Executed");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("EmployeeService @PreDestroy Executed");
    }
}
