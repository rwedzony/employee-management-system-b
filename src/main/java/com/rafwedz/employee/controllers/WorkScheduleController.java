package com.rafwedz.employee.controllers;

import com.rafwedz.employee.services.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;


@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/workschedule")
public class WorkScheduleController {


    @GetMapping("")
    public String workScheduleIndex(){
        return "workschedule controller";
    }

}
