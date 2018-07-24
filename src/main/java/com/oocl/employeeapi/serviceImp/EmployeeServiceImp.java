package com.oocl.employeeapi.serviceImp;
import com.oocl.employeeapi.model.Employee;
import com.oocl.employeeapi.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("employeeService")
public class EmployeeServiceImp implements EmployeeService {
    private Map<Long, Employee> employees;

    @Autowired
    public EmployeeServiceImp() {
        employees  = new HashMap<>();
    }

    public List<Employee> getAllEmployees() {
        if(employees.isEmpty()) return null;
        List<Employee> emp = new ArrayList<>();
        for(Map.Entry<Long, Employee> entry :employees.entrySet()){
            emp.add(entry.getValue());
        }
        return emp;
    }

    public Employee add(Employee employee){
        employees.put(employee.getId(), employee);
        return employee;
    }

    public Employee getEmployeeById(long id) {
        return employees.get(id);
    }


    public Employee modify(long id, Employee employee) {
        Employee emp = employees.get(id);
        if(employee.getGender()!=null){
            emp.setGender(employee.getGender());
        }
        if(employee.getAge()!=0){
            emp.setAge(employee.getAge());
        }
        if(employee.getName()!=null){
            emp.setName(employee.getName());
        }
        employees.replace(id, emp);
        return emp;
    }

    public Employee deleteEmployeeById(long id) {
        return employees.remove(id);
    }
}
