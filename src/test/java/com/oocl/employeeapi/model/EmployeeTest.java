package com.oocl.employeeapi.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EmployeeTest {
    @Test
    public void should_get_employee_info_when_call_get(){
    // given
        Employee employee = new Employee();
        employee.setName("tmy");
        employee.setId(1);
        employee.setAge(23);
        employee.setGender("male");
        // when
    // then
        assertEquals("tmy", employee.getName());
        assertEquals(1, employee.getId());
        assertEquals(23, employee.getAge());
        assertEquals("male", employee.getGender());
    }
}
