package com.rafwedz.employee.controllers;


import com.rafwedz.employee.models.Employee;
import com.rafwedz.employee.services.EmployeeService;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityExistsException;
import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/employees")
@CrossOrigin
public class EmployeeController {

    private final EmployeeService employeeService;


    @GetMapping("")
    //@Logging
    public List<Employee> employeeList(Model model) {
        model.addAttribute("employees", employeeService.getAllEmployees());
        return employeeService.getAllEmployees();
    }

    @GetMapping("/{emp_id}")
    public Employee getEmployeeById(@PathVariable(value="emp_id") String emp_id){
        return employeeService.getEmployeeById(Long.parseLong(emp_id)).orElseThrow(EntityExistsException::new);
    }


    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void createEmployee(@RequestBody Employee employee) {
            employeeService.save(employee);
    }

    @PutMapping(value = "/{emp_id}")
    @ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable(value = "emp_id") String emp_id, @RequestBody Employee employee) {
        Employee empTemp = employeeService.getEmployeeById(Long.parseLong(emp_id)).orElseThrow(EntityExistsException::new);
        empTemp.setFirstName(employee.getFirstName());
        empTemp.setLastName(employee.getLastName());
        empTemp.setEmail(employee.getEmail());
        empTemp.setRole(employee.getRole());
        empTemp.setCurrentMonthWorkingHours(employee.getCurrentMonthWorkingHours());
        employeeService.save(empTemp);
    }


    @DeleteMapping("/{emp_id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable(value="emp_id") long emp_id) {
        employeeService.deleteEmployeeById(emp_id);
    }

}
