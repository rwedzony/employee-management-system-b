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
public class EmployeeController {

    private final EmployeeService employeeService;


    @GetMapping("")
    //@Logging
    @CrossOrigin
    public List<Employee> employeeList(Model model) {
        //SecurityContext context= SecurityContextHolder.getContext();
        model.addAttribute("employees", employeeService.getAllEmployees());
       // model.addAttribute("message",LoggedUserDetails.getLoggedUserName());
        return employeeService.getAllEmployees();
    }

    @GetMapping("/{emp_id}")
    public Employee getEmployeeById(@PathVariable(value="emp_id") String emp_id){
        return employeeService.getEmployeeById(Long.parseLong(emp_id)).orElseThrow(EntityExistsException::new);
    }


    @PostMapping("/create")
    @ResponseStatus(HttpStatus.OK)
    public void createEmployee(@RequestBody Employee employee) {
        if (employee.getId() == 0) {
            employeeService.save(employee);
        } else {
            Employee empTemp = employeeService.getEmployeeById(employee.getId()).get();
            empTemp.setFirstName(employee.getFirstName());
            empTemp.setLastName(employee.getLastName());
            empTemp.setEmail(employee.getEmail());
            empTemp.setRole(employee.getRole());
            empTemp.setCurrentMonthWorkingHours(employee.getCurrentMonthWorkingHours());
            employeeService.save(empTemp);
        }

    }

    @PostMapping(value = "/edit")
    public String edit(@RequestParam(value = "emp_id") long emp_id, Model model) {

        Employee employee = employeeService.getEmployeeById(emp_id).get();

        model.addAttribute("employee",employee);
        //model.addAttribute("message",LoggedUserDetails.getLoggedUserName());
        return "employees/employee_form";
        //return new ModelAndView("employees/employee_form","employee",employee);
    }


    @DeleteMapping("/{emp_id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable(value="emp_id") long emp_id) {
        employeeService.deleteEmployeeById(emp_id);
    }





}
