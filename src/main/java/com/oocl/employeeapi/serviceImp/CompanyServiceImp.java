package com.oocl.employeeapi.serviceImp;

import com.oocl.employeeapi.model.Company;
import com.oocl.employeeapi.model.Employee;
import com.oocl.employeeapi.service.CompanyService;
import com.oocl.employeeapi.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service("companyService")
public class CompanyServiceImp implements CompanyService {
    private Map<Long, Company> companyMap;
    private EmployeeService employeeService;

    @Autowired
    public CompanyServiceImp(){
        companyMap = new HashMap<>();
    }

    public Company addCompany(Company company){
        List<Employee> employees = company.getEmployees();
        long id = company.getId();
        companyMap.put(id, company);

        for(Employee employee: employees){
            employeeService.add(employee);
        }

        return company;
    }

    public List<Company> getAllCompanies(){
        List<Company> companies = new ArrayList<>();
        for(Map.Entry<Long, Company> entry: companyMap.entrySet()) {
            Company company = entry.getValue();
            long id = entry.getKey();
            company.setEmployees(employeeService.getEmployeesByCompanyId(id));
            companies.add(company);
        }

        return companies;
    }

    public Company getCompanyById(long id){
        Company company = companyMap.get(id);
        List<Employee> employees = employeeService.getAllEmployees()
                                    .stream()
                                    .filter(u ->u.getCompanyId()==id)
                                    .collect(Collectors.toList());

        company.setEmployees(employees);
        return company;
    }

    public List<Employee> getEmployeesByCompanyId(long id){
        List<Employee> employees = employeeService.getAllEmployees()
                .stream()
                .filter(u ->u.getCompanyId()==id)
                .collect(Collectors.toList());
        return employees;
    }

    public Company updateCompany(long id, Company company){
        List<Employee> employees = company.getEmployees();

        companyMap.put(id, company);

        for(Employee employee: employees){
            employeeService.add(employee);
        }

        return company;
    }
}
