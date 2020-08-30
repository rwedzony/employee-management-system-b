package com.rafwedz.employee.controllers;

import com.rafwedz.employee.dto.AuthenticationResponse;
import com.rafwedz.employee.dto.LoginRequest;
import com.rafwedz.employee.dto.SimpleResponse;
import com.rafwedz.employee.services.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin
@AllArgsConstructor
public class AuthController {


    private final AuthService authService;


    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) throws Exception  {
        return authService.login(loginRequest);
    }

}
