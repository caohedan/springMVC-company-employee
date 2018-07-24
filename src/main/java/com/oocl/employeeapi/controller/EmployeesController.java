package com.oocl.employeeapi.controller;

import com.oocl.employeeapi.model.Employee;
import com.oocl.employeeapi.service.EmployeeService;
import com.oocl.employeeapi.serviceImp.EmployeeServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class EmployeesController {
    @Autowired
    private EmployeeService employeeServiceImp;

    private final AtomicLong counter = new AtomicLong();

    @PostMapping(path="/employees")
    @ResponseBody
    public Employee addEmployee(@RequestBody Employee employee){
        return employeeServiceImp.add(employee);
    }
//    public Employee addEmployee(@RequestBody Employee employee) {
//        return employeeServiceImp.add(new Employee(counter.incrementAndGet(),
//                employee.getAge(), employee.getName(), employee.getGender()));
//    }

    @PutMapping(path="/employees/{employeeId}")
    @ResponseBody
    public Employee modifyEmployee(@PathVariable long employeeId, @RequestBody Employee employee){
        return employeeServiceImp.modify(employeeId, employee);
    }

    @GetMapping(path = "/employees")
    @ResponseBody
    public List<Employee> getAllEmployees(){
        return employeeServiceImp.getAllEmployees();
    }

    @GetMapping(path = "/employees/{employeeId}")
    @ResponseBody
    public Employee getEmployeeById(@PathVariable long employeeId){
        return employeeServiceImp.getEmployeeById(employeeId);
    }

    @DeleteMapping(path = "/employees/{id}")
    @ResponseBody
    public Employee deleteEmployeeById(@PathVariable long id) {
        return employeeServiceImp.deleteEmployeeById(id);
    }
}
