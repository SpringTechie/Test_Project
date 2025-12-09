package com.springtechie.controllers;

import com.springtechie.models.Employee;
import com.springtechie.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    public EmployeeController() {
        System.out.println("EmployeeController is executed");
    }

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/get/employees")
    public List<Employee> getAllEmployees() {
       return employeeService.getAllUsers();
    }

    @GetMapping("/get/employee/id/{id}")
    public Employee findEmployeeById(@PathVariable(name = "id") Integer empId) {
        return employeeService.getEmployee(empId);
    }

    // create a new Employee
    @PostMapping("/save/employee")
    public String createNewEmployee(@RequestBody Employee employee) {
       return employeeService.saveEmployee(employee);
    }


    // update the employee
    @PutMapping("/update/emp")
    public String updateEmployee(@RequestBody Employee employee) {
       return employeeService.updateEmployee(employee);
    }
    // delete employee by id

    @DeleteMapping("/delete/emp/id/{id}")
    public String deleteById(@PathVariable int id) {
        return employeeService.deleteEmployeeById(id);
    }



}
