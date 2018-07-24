package com.oocl.employeeapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeesController {
    @Autowired
    private Employees employees;

    @PostMapping(path="/employees")
    public Employee addEmployee(@RequestBody Employee employee){
        return employees.add(employee);
    }

    @GetMapping(path = "/employees")
    public List<Employee> getAllEmployees(){
        return employees.getEmployees();
    }


}
