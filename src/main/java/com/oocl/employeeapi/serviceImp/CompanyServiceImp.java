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
    @Autowired
    private EmployeeService employeeService;

    @Autowired
    public CompanyServiceImp(){
        companyMap = new HashMap<>();
    }

    public List<Company> getAllCompanies(){
        List<Company> companies = new ArrayList<>();
        for(Map.Entry<Long, Company> entry: companyMap.entrySet()) {
            Company company = entry.getValue();
            long id = entry.getKey();
            company.setEmployees(employeeService.getEmployeesByCompanyId(id));
            company.setEmployeesNumber(company.getEmployees().size());
            companies.add(company);
        }
        return companies;
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



    public Company getCompanyById(long id){
        Company company = companyMap.get(id);
        List<Employee> employees = employeeService.getAllEmployees()
                                    .stream()
                                    .filter(u ->u.getCompanyId()==id)
                                    .collect(Collectors.toList());

        company.setEmployees(employees);
        company.setEmployeesNumber(company.getEmployees().size());
        return company;
    }

    public List<Employee> getEmployeesByCompanyId(long id){
        return employeeService.getAllEmployees()
                .stream()
                .filter(u ->u.getCompanyId()==id)
                .collect(Collectors.toList());
    }

    public Company updateCompany(long id, Company company){
        List<Employee> employees = company.getEmployees();

        companyMap.put(id, company);

        for(Employee employee: employees){
            employeeService.add(employee);
        }

        return company;
    }

    public Company deleteCompanyAndEmployeesByCompanyId(long id){
        List<Long> employeeIds = employeeService.getAllEmployees().stream()
                                .filter(u->u.getCompanyId()==id)
                                .map(u->u.getId())
                                .collect(Collectors.toList());
        for(Long ids: employeeIds){
            employeeService.deleteEmployeeById(ids);
        }

        return companyMap.remove(id);
    }

    public List<Company> getCompanyByPage(int page, int size){
        List<Company> allCompanies = getAllCompanies();
        int totalSize = allCompanies.size();
        int preNum = (page-1)*size;
        if(totalSize <= preNum)
            return null;

        List<Company> companies = new ArrayList<>();
        for(int i = preNum; i < totalSize && companies.size()<=size; i++){
            companies.add(allCompanies.get(i));
    }

        return companies;
    }
}
