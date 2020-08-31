package com.rafwedz.employee.controllers;


import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;

@RestController
@RequestMapping(value = "/test2")
@CrossOrigin
public class TestController2 {

    @GetMapping("")
    //@PreAuthorize("hasRole('ROLE_USER')")
    @RolesAllowed({"ROLE_USER","ROLE_ADMIN"})
    public String index(){
        return "test 2- user-and-admin only";
    }
}
