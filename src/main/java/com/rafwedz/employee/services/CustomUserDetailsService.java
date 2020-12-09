package com.rafwedz.employee.services;

import com.rafwedz.employee.employee.Employee;
import com.rafwedz.employee.employee.EmployeeRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final EmployeeRepository employeeRepository;


    public CustomUserDetailsService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Employee employee=employeeRepository.findUserByUsername(username)
                .orElseThrow(()->new UsernameNotFoundException("User not Found"));
        return new User(employee.getEmail(),employee.getPassword(),
                Collections.singleton(new SimpleGrantedAuthority(employeeRepository.findRoleByUsername(username))));



    }
}
