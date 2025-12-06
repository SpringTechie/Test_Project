package com.springtechie.service;

import com.springtechie.models.Employee;
import com.springtechie.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAllUsers() {
        List<Employee>  empList =  employeeRepository.findAll();
        return empList;
    }

    // to get any data based on primary key use the findById().
    public Employee getEmployee(Integer id) {
       Optional<Employee> emp =  employeeRepository.findById(id);
       if(emp.isPresent()) {
           return emp.get();
       }
       else {
           throw new RuntimeException("No Employee Found with id =" + id );
       }

    }

    public String saveEmployee(Employee employee) {
        Employee save = employeeRepository.save(employee);
        if (save != null) {
            return "Employee saved successfully";
        }
        else {
            return "Failed save Employee with id" + employee.getId();
        }
    }
}
