package com.rafwedz.employee.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping(value = "/workschedule")
public class WorkScheduleController {

    @GetMapping("")
    public String workScheduleIndex(Model model){
        SecurityContext context= SecurityContextHolder.getContext();
        model.addAttribute("message",context.getAuthentication().getName());
        return "workschedule/workschedule";
    }

}
