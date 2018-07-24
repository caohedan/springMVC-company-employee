package com.oocl.employeeapi;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Employees {
    private List<Employee> employees;

    public Employees(List<Employee> employees) {
        this.employees = employees;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public Employee add(Employee employee){
        employees.add(employee);
        return employee;
    }

    public Employee getEmployeeById(int id) {
        for(Employee employee: employees){
            if(employee.getId() == id){
                return employee;
            }
        }
        return null;
    }
}
