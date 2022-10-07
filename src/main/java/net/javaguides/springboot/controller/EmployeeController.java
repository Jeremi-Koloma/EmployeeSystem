package net.javaguides.springboot.controller;

import lombok.AllArgsConstructor;
import net.javaguides.springboot.exception.ResourceNotFoundException;
import net.javaguides.springboot.model.Employee;
import net.javaguides.springboot.repository.EmployeeRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/")
@AllArgsConstructor
public class EmployeeController {
    private final EmployeeRepository employeeRepository;

    // get All employees rest API
    @GetMapping("/employees")
    private List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }

    // create employee rest API
    @PostMapping("/employees/create")
    public Employee createEmployee(@RequestBody Employee employee){
        return employeeRepository.save(employee);
    }

    // get employee by id API
    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id){
    Employee employee = employeeRepository.findById(id)
            .orElseThrow(()-> new ResourceNotFoundException("Employee not exist with id : " + id));
    return ResponseEntity.ok(employee);
    }

    // Update employee rest API
    @PutMapping ("/employees/update/{id}")
    public ResponseEntity<Employee> updatedEmployee(@PathVariable Long id, @RequestBody Employee employeeDetails){
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Employee not exist with id : " + id));
        employee.setFirstName(employeeDetails.getFirstName());
        employee.setLastName(employeeDetails.getLastName());
        employee.setEmailId(employeeDetails.getEmailId());

        Employee updatedEmployee = employeeRepository.save(employee);
        return ResponseEntity.ok(updatedEmployee);
    }

}
