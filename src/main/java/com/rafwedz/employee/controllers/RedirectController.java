package com.rafwedz.employee.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedirectController {
    @GetMapping("/")
    public String redirectToEmployees(){
        return "ENTRY POINT OF THE APPLICATION";
    }
}
