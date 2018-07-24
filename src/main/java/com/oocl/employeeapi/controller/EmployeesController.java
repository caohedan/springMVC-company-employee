package com.oocl.employeeapi.controller;

import com.oocl.employeeapi.model.Employee;
import com.oocl.employeeapi.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/employees")
public class EmployeesController {
    @Autowired
    private EmployeeService employeeService;

    private final AtomicLong counter = new AtomicLong();

    @PostMapping(path="")
    @ResponseBody
    public Employee addEmployee(@RequestBody Employee employee){
//        Employee emp = new Employee(counter.incrementAndGet(),
//                                    employee.getAge(),
//                                    employee.getName(),
//                                    employee.getGender());
        return employeeService.add(employee);
    }

    @PutMapping(path="/{employeeId}")
    @ResponseBody
    public Employee modifyEmployee(@PathVariable long employeeId, @RequestBody Employee employee){
        return employeeService.modify(employeeId, employee);
    }

    @GetMapping(path = "")
    @ResponseBody
    public List<Employee> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    @GetMapping(path = "/{employeeId}")
    @ResponseBody
    public Employee getEmployeeById(@PathVariable long employeeId){
        return employeeService.getEmployeeById(employeeId);
    }

    @DeleteMapping(path = "/{employeeId}")
    @ResponseBody
    public Employee deleteEmployeeById(@PathVariable long employeeId) {
        return employeeService.deleteEmployeeById(employeeId);
    }

    @GetMapping(path="/male")
    public List<Employee> getMaleEmployees(){
        return employeeService.getMaleEmployees();
    }
}
