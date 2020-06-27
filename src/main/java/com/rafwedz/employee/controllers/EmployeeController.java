package com.rafwedz.employee.controllers;

import com.rafwedz.employee.models.Employee;
import com.rafwedz.employee.services.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class EmployeeController {
    private final EmployeeService employeeService;
    public EmployeeController(EmployeeService employeeService){
        this.employeeService=employeeService;
    }

    @GetMapping("/")
    public String welcomePage(Model model){
        model.addAttribute("employees",employeeService.getAllEmployees());
        return "index";
    }


}
