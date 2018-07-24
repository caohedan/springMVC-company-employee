package com.oocl.employeeapi.controller;

import com.oocl.employeeapi.model.Company;
import com.oocl.employeeapi.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/companies")
public class CompanyController {
    @Autowired
    private CompanyService companyService;

    private final AtomicLong counter = new AtomicLong();

    @GetMapping(path="")
    public List<Company> getCompanies(){
        return companyService.getAllCompanies();
    }

    @PostMapping(path="")
    public Company addCompany(@RequestBody Company company){
        return companyService.addCompany(company);
    }

    @GetMapping(path = "/{companyId}")
    public Company getCompanyById(@PathVariable long companyId){
        return companyService.getCompanyById(companyId);
    }
}
