package com.avi.ganguly.demoemployeerest.repository;

import com.avi.ganguly.demoemployeerest.beans.Employee;
import com.avi.ganguly.demoemployeerest.beans.response.Response;

import java.util.List;
import java.util.Optional;

public interface IEmployeeRepository {

    List<Employee> getAllEmployees();

    void createEmployee(Employee employee);

    Optional<Employee> getEmployee(String id);

    Response updateEmployee(String id, Employee employee);

    boolean deleteEmployee(String id);

    List<Employee> getEmployeeByName(String name);
}
