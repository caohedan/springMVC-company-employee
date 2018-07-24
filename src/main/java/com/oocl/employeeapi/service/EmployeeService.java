package com.oocl.employeeapi.service;

import com.oocl.employeeapi.model.Employee;

import java.util.List;

public interface EmployeeService {

    Employee add(Employee employee);

    Employee modify(long id, Employee employee);

    List<Employee> getAllEmployees();

    Employee getEmployeeById(long id);

    Employee deleteEmployeeById(long id);
    List<Employee> getEmployeesByCompanyId(long companyId);

    List<Employee> getMaleEmployees();

}
