package com.oocl.employeeapi.serviceImp;

import com.oocl.employeeapi.model.Employee;
import org.junit.Test;

import java.util.List;

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

    @Test
    public void should_return_employee_list_when_call_getAllEmployees(){
    // given
        Employee employee1 = mock(Employee.class);
        Employee employee2 = mock(Employee.class);
        EmployeeServiceImp employeeServiceImp = new EmployeeServiceImp();
        when(employee1.getId()).thenReturn((long)1);
        when(employee2.getId()).thenReturn((long)2);
        employeeServiceImp.add(employee1);
        employeeServiceImp.add(employee2);

        // when
        List<Employee> result = employeeServiceImp.getAllEmployees();
    // then
        assertEquals((long)1, result.get(0).getId());
        assertEquals((long)2, result.get(1).getId());
    }

    @Test
    public void should_update_employee_when_call_modify(){
        // given
        Employee employee1 = mock(Employee.class);
        Employee employee2 = mock(Employee.class);
        EmployeeServiceImp employeeServiceImp = new EmployeeServiceImp();
        when(employee1.getId()).thenReturn((long)1);
        when(employee1.getName()).thenReturn("unmodify").thenReturn("modified");
        when(employee2.getName()).thenReturn("modified");
        employeeServiceImp.add(employee1);


        // when
        employeeServiceImp.modify((long)1, employee2);
        Employee result = employeeServiceImp.getEmployeeById((long)1);
                // then
        assertEquals("modified", result.getName());
    }

    @Test
    public void should_delete_employee_when_call_deleteEmployeeById(){
        // given
        Employee employee1 = mock(Employee.class);
        EmployeeServiceImp employeeServiceImp = new EmployeeServiceImp();
        when(employee1.getId()).thenReturn((long)1);
        employeeServiceImp.add(employee1);
        // when
        employeeServiceImp.deleteEmployeeById((long) 1);
        List<Employee> result = employeeServiceImp.getAllEmployees();
        // then
        assertEquals(null, result);
    }
}
