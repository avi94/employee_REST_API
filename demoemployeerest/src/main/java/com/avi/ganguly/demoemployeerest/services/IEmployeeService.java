package com.avi.ganguly.demoemployeerest.services;

import com.avi.ganguly.demoemployeerest.beans.Employee;
import com.avi.ganguly.demoemployeerest.beans.response.Response;

import java.util.List;

public interface IEmployeeService {

    List<Employee> getAllEmployees();

    void createEmployee(Employee employee);

    Employee getEmployee(String id) throws Exception;

    Response updateEmployee(String id, Employee employee) throws Exception;

    Response deleteEmployee(String id) throws Exception;

    List<Employee> getEmployeeByName(String name) throws Exception;
}
