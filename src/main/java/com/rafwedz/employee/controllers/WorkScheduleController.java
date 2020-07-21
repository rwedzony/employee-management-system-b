package com.rafwedz.employee.controllers;

import com.rafwedz.employee.services.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/workschedule")
public class WorkScheduleController {

    private final EmployeeService employeeService;

    @GetMapping("")
    public String workScheduleIndex(Model model){
        SecurityContext context= SecurityContextHolder.getContext();
        model.addAttribute("message",context.getAuthentication().getName());
        model.addAttribute("employees", employeeService.getAllEmployees());
        return "workschedule/workschedule";
    }

}
