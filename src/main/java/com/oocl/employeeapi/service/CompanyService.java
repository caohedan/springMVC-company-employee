package com.oocl.employeeapi.service;

import com.oocl.employeeapi.model.Company;

import java.util.List;

public interface CompanyService {
    List<Company> getAllCompanies();

    Company addCompany(Company company);

}
