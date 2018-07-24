package com.oocl.employeeapi.serviceImp;

import com.oocl.employeeapi.model.Employee;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class EmployeeServiceImpTest {
    @Test
    public void should_add_successful_when_call_add_given_employee(){
    // given
        Employee employee = mock(Employee.class);
        EmployeeServiceImp employeeServiceImp = new EmployeeServiceImp();
        when(employee.getName()).thenReturn("terry");
        when(employee.getId()).thenReturn((long) 1);

        // when
        employeeServiceImp.add(employee);
        Employee result = employeeServiceImp.getEmployeeById((long)1);
    // then
        assertEquals("terry", result.getName());
    }
}
