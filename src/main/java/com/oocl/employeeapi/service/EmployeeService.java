package com.oocl.employeeapi.service;
import com.oocl.employeeapi.model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EmployeeService {
    private Map<Long, Employee> employees = new HashMap<>();

    public EmployeeService(List<Employee> employees) {
        for (Employee employee: employees){
            this.employees.put(employee.getId(), employee);
        }
    }

    public List<Employee> getEmployees() {
        List<Employee> emp = new ArrayList<>();
        for(Map.Entry<Long, Employee> entry :employees.entrySet()){
            emp.add(entry.getValue());
        }
        return emp;
    }

    public Employee add(Employee employee){
        employees.put(employee.getId(),employee);
        return employee;
    }

    public Employee getEmployeeById(long id) {
        return employees.get(id);
    }


    public Employee modify(long id, Employee employee) {
        return employees.replace(id, employee);
    }

    public Employee deleteEmployeeById(long id) {
        return employees.remove(id);
    }
}
