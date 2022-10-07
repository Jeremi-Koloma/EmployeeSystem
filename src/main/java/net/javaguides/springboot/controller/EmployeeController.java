package net.javaguides.springboot.controller;

import lombok.AllArgsConstructor;
import net.javaguides.springboot.model.Employee;
import net.javaguides.springboot.repository.EmployeeRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/")
@AllArgsConstructor
public class EmployeeController {
    private final EmployeeRepository employeeRepository;

    // get All employees
    @GetMapping("/employees")
    private List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }

    // create employee rest API
    @PostMapping("/employees/create")
    public Employee createEmployee(@RequestBody Employee employee){
        return employeeRepository.save(employee);
    }



}
