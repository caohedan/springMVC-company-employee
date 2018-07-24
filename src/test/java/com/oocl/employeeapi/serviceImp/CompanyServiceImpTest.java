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
import static org.mockito.ArgumentMatchers.longThat;
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

    @Test
    public void should_get_the_company_when_call_getCompanyById(){
    // given
        Company company = mock(Company.class);
        Employee employee = mock(Employee.class);
        List<Employee> employees = new ArrayList<>();
        employees.add(employee);
        when(company.getId()).thenReturn((long)1);
        when(employeeService.getAllEmployees()).thenReturn(employees);
        companyServiceImp.addCompany(company);
    // when
        Company company1 = companyServiceImp.getCompanyById((long)1);
    // then
        assertEquals((long)1, company1.getId());
    }

    @Test
    public void should_get_the_employees_when_call_getEmployeesByCompanyId(){
        // given
        Company company = mock(Company.class);
        Employee employee = mock(Employee.class);
        when(employee.getCompanyId()).thenReturn((long)1);
        List<Employee> employees = new ArrayList<>();
        employees.add(employee);
        when(company.getId()).thenReturn((long)1);
        when(employeeService.getAllEmployees()).thenReturn(employees);
        companyServiceImp.addCompany(company);
        // when
        List<Employee> employees1 = companyServiceImp.getEmployeesByCompanyId((long)1);
        // then
        assertEquals((long)1, employees1.get(0).getCompanyId());
    }

    @Test
    public void should_update_company_when_call_updateCompany(){
    // given
        Employee employee = mock(Employee.class);
        when(employee.getCompanyId()).thenReturn((long)1);
        when(employee.getId()).thenReturn((long)0);
        Company company = mock(Company.class);
        when(company.getId()).thenReturn((long)1);
        when(company.getCompanyName()).thenReturn("aaa");
        Company company1 = mock(Company.class);
        when(company1.getCompanyName()).thenReturn("bbb");

        List<Employee> employees = new ArrayList<>();
        employees.add(employee);

        companyServiceImp.addCompany(company);
        // when
        companyServiceImp.updateCompany(1, company1);
    // then
        assertEquals("bbb", companyServiceImp.getCompanyById((long)1).getCompanyName());
    }

    @Test
    public void should_delete_the_company_when_call_deleteCompanyAndEmployeesByCompanyId(){
        // given
        Employee employee = mock(Employee.class);
        when(employee.getCompanyId()).thenReturn((long)1);
        when(employee.getId()).thenReturn((long)0);
        Company company = mock(Company.class);
        when(company.getId()).thenReturn((long)1);
        when(company.getCompanyName()).thenReturn("aaa");

        List<Employee> employees = new ArrayList<>();
        employees.add(employee);

        companyServiceImp.addCompany(company);
        // when
        companyServiceImp.deleteCompanyAndEmployeesByCompanyId(1);
        // then
        assertEquals(0, companyServiceImp.getAllCompanies().size());
    }
}
