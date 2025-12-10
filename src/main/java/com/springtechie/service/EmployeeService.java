package com.springtechie.service;

import com.springtechie.models.Employee;
import com.springtechie.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {


    public EmployeeService() {
        System.out.println("Employeeservice is executed");
    }

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAllUsers() {
        return employeeRepository.findAll();
    }

    // to get any data based on primary key use the findById().
    public Employee getEmployee(Integer id) {
       Optional<Employee> emp =  employeeRepository.findById(id);
        employeeRepository.findAllById(List.of(1,2));
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
            return "Failed save Employee with id" + employee;
        }
    }

    public String deleteEmployeeById(int id) {
        if(employeeRepository.existsById(id)) {
            employeeRepository.deleteById(id);
            return "Employee Deleted Successfully";
        }
        return "No Employee Found with id" + id;

    }

    public String updateEmployee(Employee employee) {
       if( employeeRepository.save(employee) != null) {
           return "Updated Succesfully";
       }
       return "Failed to update";
    }

    public List<Employee> getEmployeeByIDs(List<Integer> ids) {
        System.out.println("Requested Employee IDs: " + ids);
        ids.forEach(id -> System.out.println("Fetching Employee with ID: " + id));
        // Fetch employees first
        List<Employee> employees = employeeRepository.findAllById(ids);


        List<Integer> foundIds = employees.stream()
                .map(Employee::getId)
                .toList();
        //Find missing IDs
        List<Integer> missingIds = ids.stream()
                .filter(id -> !foundIds.contains(id))
                .toList();

        if (!missingIds.isEmpty()) {
            System.out.println("IDs not found: " + missingIds);
        }

        return employees;
    }

}
