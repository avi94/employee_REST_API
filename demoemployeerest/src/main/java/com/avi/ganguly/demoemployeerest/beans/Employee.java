package com.avi.ganguly.demoemployeerest.beans;

public class Employee {
    private String employeeId;
    private String name;
    private String designation;
    private Integer salary;

    public Employee(String employeeId, String name, String designation, Integer salary) {
        this.employeeId = employeeId;
        this.name = name;
        this.designation = designation;
        this.salary = salary;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }
}
