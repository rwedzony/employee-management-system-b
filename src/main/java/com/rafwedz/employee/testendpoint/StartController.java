package com.rafwedz.employee.testendpoint;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class StartController {

    @GetMapping("/start")
    public String redirectToEmployees(){
        StringBuilder sb=new StringBuilder();
        sb.append("ENTRY POINT OF THE APPLICATION");
        return sb.toString();
    }
}
