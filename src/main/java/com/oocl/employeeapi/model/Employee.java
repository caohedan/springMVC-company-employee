package com.oocl.employeeapi.model;

import org.springframework.stereotype.Component;

@Component
public class Employee {
    private long id;
    private int age;
    private String name;
    private String gender;

//    public Employee(int _id, int _age, String _name, String _gender){
//        id = _id;
//        age = _age;
//        name = _name;
//        gender = _gender;
//    }

    public int getAge() {
        return age;
    }

    public long getId() {
        return id;
    }

    public String getGender() {
        return gender;
    }

    public String getName() {
        return name;
    }
}
