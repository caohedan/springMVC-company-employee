package com.oocl.employeeapi.serviceImp;

import com.oocl.employeeapi.model.Company;
import com.oocl.employeeapi.model.Employee;
import com.oocl.employeeapi.service.CompanyService;
import com.oocl.employeeapi.service.EmployeeService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CompanyServiceImpTest {
    @Mock
    EmployeeService employeeService;
    @InjectMocks
    CompanyServiceImp companyServiceImp = new CompanyServiceImp();

    @Before
    public void initMock(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void should_add_success_when_call_addCompany(){
    // given
        Company company = mock(Company.class);
        Employee employee = mock(Employee.class);
        List<Employee> employees = new ArrayList<>();
        employees.add(employee);
        
        when(company.getId()).thenReturn((long)1);
        when(company.getEmployees()).thenReturn(employees);
        when(employeeService.add(employee)).thenReturn(employee);
    // when
        companyServiceImp.addCompany(company);
        List<Company> companies = companyServiceImp.getAllCompanies();
    // then
        assertEquals(1, companies.size());
        assertEquals((long)1, companies.get(0).getId());
    }
}
