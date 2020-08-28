package com.rafwedz.employee.controllers;

import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class RedirectController {
    @GetMapping("/")
    public String redirectToEmployees(){
        StringBuilder sb=new StringBuilder();
        SecurityContext context = SecurityContextHolder.getContext();
        sb.append("ENTRY POINT OF THE APPLICATION");
        sb.append("your are logged as: "+context.getAuthentication().getName());
        return sb.toString();
    }
}
