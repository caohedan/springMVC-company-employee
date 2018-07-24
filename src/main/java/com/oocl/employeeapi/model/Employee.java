package com.oocl.employeeapi.model;

import org.springframework.stereotype.Component;

@Component
public class Employee {


    private long id;
    private int age;
    private String name;
    private String gender;
    private long companyId;



    public Employee(){}
    public Employee(long _id, int _age, String _name, String _gender){
        id = _id;
        age = _age;
        name = _name;
        gender = _gender;
    }

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

    public void setName(String name) {
        this.name = name;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(long companyId) {
        this.companyId = companyId;
    }
}
