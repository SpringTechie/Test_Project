package com.springtechie.service;

import com.springtechie.dto.EmployeeBonusDTO;
import com.springtechie.exceptions.EmployeeNotFoundException;
import com.springtechie.models.Employee;
import com.springtechie.repositories.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
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
        log.info("fetching data for employeeId= {}" ,id);
        Optional<Employee> emp = employeeRepository.findById(id);
        employeeRepository.findAllById(List.of(1, 2));
        if (emp.isPresent()) {
            log.info("Employee Found with id ={} ",id);
            return emp.get();
        } else {
            log.error("No Employee Found with id = {}", id);
            throw new EmployeeNotFoundException("No Employee Found with id =" + id);
        }

    }

    public String saveEmployee(Employee employee) {
        Employee save = employeeRepository.save(employee);
        if (save != null) {
            return "Employee saved successfully";
        } else {
            return "Failed save Employee with id" + employee;
        }
    }

    public String deleteEmployeeById(int id) {
        if (employeeRepository.existsById(id)) {
            employeeRepository.deleteById(id);
            return "Employee Deleted Successfully";
        }
        return "No Employee Found with id" + id;

    }

    public String updateEmployee(Employee employee) {
        if (employeeRepository.save(employee) != null) {
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
            // TO-DO
            // replace print statement with log.
            // warn level
            System.out.println("IDs not found: " + missingIds);
        }

        return employees;
    }

    //getEmployeeBonus
    public List<EmployeeBonusDTO> getEmployeeBonus() {
        List<Employee> employees = employeeRepository.findAll();

    return employees.stream()
            .map(emp -> {
                Double salary = emp.getSalary();
                double bonus = calculateBonus(salary);

                return new EmployeeBonusDTO(
                        emp.getId(),
                        emp.getName(),
                        salary,
                        bonus
                );
            })
            .toList();
}
    private double calculateBonus(Double salary) {
        if (salary == null) {
            return 0.0;
        }
        if (salary > 100000) {
            return salary * 0.05;
        } else if (salary >= 50000) {
            return salary * 0.15;
        } else {
            return salary * 0.20;
        }
    }

    public List<Employee> emps(Integer id) {
        if(id != null) {
            Optional<Employee> emp = employeeRepository.findById(id);
           if(emp.isPresent()) {
               return List.of(emp.get());
           }
        }
         else {
            return employeeRepository.findAll();
        }
         return Collections.emptyList();

    }
}
