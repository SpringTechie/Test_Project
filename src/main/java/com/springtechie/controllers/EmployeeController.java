package com.springtechie.controllers;

import com.springtechie.models.Employee;
import com.springtechie.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;



    @GetMapping("/get/employees")
    public List<Employee> getAllEmployees() {
       return employeeService.getAllUsers();
    }
    // select * from employee where id = 2;
    // http://localhost:8080/get/employee/id/2/name/arun
    // path variable to method variable binding
    @GetMapping("/get/employee/id/{id}")
    public Employee findEmployeeById(@PathVariable(name = "id") Integer empId) { // id = null
        return employeeService.getEmployee(empId);
    }

    // create a new Employee
    @PostMapping("/save/employee")
    public String createNewEmployee(@RequestBody Employee employee) {
       return employeeService.saveEmployee(employee);
    }




}
