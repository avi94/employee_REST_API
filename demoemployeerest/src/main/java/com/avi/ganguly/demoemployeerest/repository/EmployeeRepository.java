package com.avi.ganguly.demoemployeerest.repository;

import com.avi.ganguly.demoemployeerest.beans.Employee;
import com.avi.ganguly.demoemployeerest.beans.response.Response;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class EmployeeRepository implements IEmployeeRepository {

    List<Employee> employees = new ArrayList<>();

    @Override
    public List<Employee> getAllEmployees() {
        return employees;
    }

    @Override
    public void createEmployee(Employee employee) {
        employees.add(employee);
    }

    @Override
    public Optional<Employee> getEmployee(String id) {

        Optional<Employee> employee = employees.stream()
                .filter(emp -> emp.getEmployeeId().equals(id))
                .findFirst();

        return employee;

    }

    @Override
    public Response updateEmployee(String id, Employee employee) {

        Optional<Employee> optionalEmployee = employees.stream()
                .filter(emp -> emp.getEmployeeId().equals(id))
                .findFirst();

        if (optionalEmployee.isPresent()) {

            Employee emp = optionalEmployee.get();
            emp.setName(employee.getName());
            emp.setSalary(employee.getSalary());
            emp.setDesignation(employee.getDesignation());

            return new Response(false, String.format("Employee with id %s updated", id));
        }

        return null;
    }

    @Override
    public boolean deleteEmployee(String id) {
        return employees.removeIf(emp -> emp.getEmployeeId().equals(id));
    }

    @Override
    public List<Employee> getEmployeeByName(String name) {
        List<Employee> collectEmployees = employees.stream()
                .filter(emp -> emp.getName().contains(name))
                .collect(Collectors.toList());
        return collectEmployees;
    }
}
