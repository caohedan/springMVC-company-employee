package com.oocl.employeeapi.service;

import com.oocl.employeeapi.model.Company;
import com.oocl.employeeapi.model.Employee;

import java.util.List;

public interface CompanyService {
    List<Company> getAllCompanies();

    Company addCompany(Company company);

    Company getCompanyById(long companyId);

    List<Employee> getEmployeesByCompanyId(long companyId);

    Company updateCompany(long companyId, Company company);

    Company deleteCompanyAndEmployeesByCompanyId(long companyId);

    List<Company> getCompanyByPage(int page, int size);
}
