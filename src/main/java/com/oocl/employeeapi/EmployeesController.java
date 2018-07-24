package com.oocl.employeeapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class EmployeesController {
    @Autowired
    private EmployeeService employeeService;

    private final AtomicLong counter = new AtomicLong();

    @PostMapping(path="/employees")
    @ResponseBody
    public Employee addEmployee(@RequestBody Employee employee){
        return employeeService.add(employee);
    }

    @PostMapping(path="/employees/{id}")
    @ResponseBody
    public Employee addEmployee(@PathVariable long id, @RequestBody Employee employee){
        return employeeService.modify(id, employee);
    }

    @GetMapping(path = "/employees")
    @ResponseBody
    public List<Employee> getAllEmployees(){
        return employeeService.getEmployees();
    }

    @GetMapping(path = "/employees/{id}")
    @ResponseBody
    public Employee getEmployeeById(@PathVariable long id){
        return employeeService.getEmployeeById(id);
    }

    @DeleteMapping(path = "/employees/{id}")
    @ResponseBody
    public Employee deleteEmployeeById(@PathVariable long id) {
        return employeeService.deleteEmployeeById(id);
    }
}
