package com.avi.ganguly.demoemployeerest.services;

import com.avi.ganguly.demoemployeerest.beans.Employee;
import com.avi.ganguly.demoemployeerest.beans.response.Response;
import com.avi.ganguly.demoemployeerest.repository.IEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService implements IEmployeeService {

    @Autowired
    IEmployeeRepository repository;

    @Override
    public List<Employee> getAllEmployees() {
        return repository.getAllEmployees();
    }

    @Override
    public void createEmployee(Employee employee) {
        repository.createEmployee(employee);
    }

    @Override
    public Employee getEmployee(String id) throws Exception {

        Optional<Employee> optionalEmployee = repository.getEmployee(id);

        if (optionalEmployee.isPresent()) {
            return optionalEmployee.get();
        }
        throw new Exception(String.format("Employee with id %s is not present", id));
    }

    @Override
    public Response updateEmployee(String id, Employee employee) throws Exception {
        Response response = repository.updateEmployee(id, employee);
        if (response != null) {
            return response;
        }
        throw new Exception(String.format("Employee with id %s not present", id));
    }

    @Override
    public Response deleteEmployee(String id) throws Exception {
        if (repository.deleteEmployee(id)) {
            return new Response(false, String.format("Employee with id %s has been deleted", id));
        }
        throw new Exception(String.format("Employee with id %s not present", id));
    }

    @Override
    public List<Employee> getEmployeeByName(String name) throws Exception {
        return repository.getEmployeeByName(name);
    }
}
