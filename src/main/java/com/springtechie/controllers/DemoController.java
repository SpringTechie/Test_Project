package com.springtechie.controllers;

import com.springtechie.exceptions.EmployeeNotFoundException;
import com.springtechie.models.Employee;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.Map;

@RestController
public class DemoController {

    @GetMapping("/get/id/")
    public Employee findEmployeeById() {
        // business logic
        throw new EmployeeNotFoundException("emp not found");

    }
}
