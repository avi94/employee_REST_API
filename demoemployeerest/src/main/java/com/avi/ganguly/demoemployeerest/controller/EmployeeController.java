package com.avi.ganguly.demoemployeerest.controller;

import com.avi.ganguly.demoemployeerest.beans.Employee;
import com.avi.ganguly.demoemployeerest.beans.response.Response;
import com.avi.ganguly.demoemployeerest.services.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1")
public class EmployeeController {

    @Autowired
    IEmployeeService service;

    @GetMapping("employees")
    public List<Employee> getAllEmployees() {
        return service.getAllEmployees();
    }

    @GetMapping("employees/{id}")
    public Employee getEmployee(@PathVariable String id) throws Exception {
        return service.getEmployee(id);
    }

    @PostMapping("employees")
    public void createEmployee(@RequestBody Employee employee) {
        service.createEmployee(employee);
    }

    @PutMapping(value = "employees/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Response updateEmployee(@PathVariable String id, @RequestBody Employee employee) throws Exception {
        return service.updateEmployee(id, employee);
    }

    @DeleteMapping("employees/{id}")
    public Response deleteUpdate(@PathVariable String id) throws Exception {
        return service.deleteEmployee(id);
    }

    @GetMapping(value = "employees", params = {"name"})
    public List<Employee> getEmployeeByName(@RequestParam("name") String name) throws Exception {
        return service.getEmployeeByName(name);
    }
}
