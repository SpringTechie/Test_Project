package com.springtechie.controllers;

import com.springtechie.dto.EmployeeBonusDTO;
import com.springtechie.models.Employee;
import com.springtechie.service.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@Slf4j
@Tag(name="Employee-Controller",description = "This controller has Employee related AP's")
public class EmployeeController {

    @Value("${employee.rating:3}")
    private List<Integer> rating;

    public EmployeeController() {
        System.out.println("EmployeeController is executed");
    }

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/get/employees")
    public List<Employee> getAllEmployees() {
        System.out.println("rating= "+ rating);
       return employeeService.getAllUsers();
    }

    @Operation(summary = "Fetches the Employee Based on Id",description = "Pass the Employee Id")
    @Parameter(name="id",description = "Enter Employee Id",example = "2")
    @ApiResponse(responseCode = "200",description = "Returns employee data if found")
    @ApiResponse(responseCode = "204",description = "Returns NO content if  Employee with Id not found")
    @GetMapping("/get/employee/id/{id}")
    public Employee findEmployeeById(@PathVariable(name = "id") Integer empId) {
        long startTime = System.currentTimeMillis();
        log.info("requested started at time {}",System.currentTimeMillis());
        Employee employee = employeeService.getEmployee(empId);
        log.info("requested completed at time {}",System.currentTimeMillis());
        long endTime = System.currentTimeMillis();
        log.info("Total time taken {}",endTime-startTime);
        return employee;

    }

    // create a new Employee
    @PostMapping(path = "/save/employee",consumes = {"application/json"},produces = {"application/json"})
    public ResponseEntity<String> createNewEmployee(@RequestBody Employee employee) {
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        headers.put(HttpHeaders.AGE, Collections.singletonList("23"));
        HttpHeaders httpHeaders = new HttpHeaders(headers);
        return new ResponseEntity<>(employeeService.saveEmployee(employee),httpHeaders,HttpStatusCode.valueOf(201));
    }

    // update the employee
    @PutMapping("/update/emp")
    public String updateEmployee(@RequestBody Employee employee) {
        employeeService.updateEmployee(employee);
        return "Updated Successfully";
    }

    // delete employee by id
    @DeleteMapping("/delete/emp/id/{id}")
    public String deleteById(@PathVariable int id) {
        return employeeService.deleteEmployeeById(id);
    }

    //fetch all Employees by given IDs
    @GetMapping("/employees/byid")
    public List<Employee> getEmployeesByIds(@RequestParam List<Integer> ids) {
        return employeeService.getEmployeeByIDs(ids);
    }

    // add bonus api
    @GetMapping("/employee/add-bonus")
    public List<EmployeeBonusDTO> getEmployeeBonus() {
            return employeeService.getEmployeeBonus();
    }

    // RequestParam annotation.
    @GetMapping("get/allorone/emp/data")
    public ResponseEntity<List<Employee>> employeeData(@RequestParam(required = false) Integer id) {
        List<Employee> emps = employeeService.emps(id);
        if(emps.isEmpty()) {
            HttpStatusCode httpStatusCode = HttpStatusCode.valueOf(204);
            return new ResponseEntity<>(emps,httpStatusCode);
        }
        HttpStatusCode httpStatusCode = HttpStatusCode.valueOf(200);
        return new ResponseEntity<>(emps,httpStatusCode);

    }

}
