package com.oocl.employeeapi.serviceImp;

import com.oocl.employeeapi.model.Company;
import com.oocl.employeeapi.service.CompanyService;
import com.oocl.employeeapi.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service("companyService")
public class CompanyServiceImp implements CompanyService {
    private Map<Integer, Company> companyMap;
    private EmployeeService employeeService;


}
