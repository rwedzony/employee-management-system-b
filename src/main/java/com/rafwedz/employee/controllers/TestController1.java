package com.rafwedz.employee.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;

@RestController
@RequestMapping(value = "/test1")
@CrossOrigin
public class TestController1 {

    @GetMapping("")
    //@PreAuthorize("hasRole('ROLE_ADMIN')")
    @RolesAllowed({"ROLE_ADMIN"})
    public String index(){
        return "test 1- Admin-only";
    }
}
