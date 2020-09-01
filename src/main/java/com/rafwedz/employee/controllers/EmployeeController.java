package com.rafwedz.employee.controllers;


import com.rafwedz.employee.models.Employee;
import com.rafwedz.employee.services.EmployeeService;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.*;


import javax.persistence.EntityExistsException;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/employees")
@CrossOrigin
public class EmployeeController {

    private final EmployeeService employeeService;


    @GetMapping("")
    //@Logging
    public List<Employee> employeeList() {
        System.out.println("get ALL in GET MAPPING");
        List<Employee> employees =new ArrayList<>();
        employees=employeeService.getAllEmployees();
        return employees;
    }


    @GetMapping("/{emp_id}")
    public Employee getEmployeeById(@PathVariable(value="emp_id") String emp_id){
        System.out.println("GET by ID fuction");
        return employeeService.getEmployeeById(Long.parseLong(emp_id)).orElseThrow(EntityExistsException::new);
    }


    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void createEmployee(@RequestBody Employee employee) {
        System.out.println("create function");
        employeeService.save(employee);
    }

    @PutMapping(value = "/{emp_id}")
    @ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable(value = "emp_id") String emp_id, @RequestBody Employee employee) {
        System.out.println("update function");
        Employee empTemp = employeeService.getEmployeeById(Long.parseLong(emp_id)).orElseThrow(EntityExistsException::new);
        empTemp.setFirstName(employee.getFirstName());
        empTemp.setLastName(employee.getLastName());
        empTemp.setEmail(employee.getEmail());
        empTemp.setOccupation(employee.getOccupation());
        empTemp.setCurrentMonthWorkingHours(employee.getCurrentMonthWorkingHours());
        employeeService.save(empTemp);

    }


    @DeleteMapping(value="/{emp_id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable(value="emp_id") String emp_id) {
        System.out.println("delete function");
        employeeService.deleteEmployeeById(Long.parseLong(emp_id));
    }

}
