package com.rafwedz.employee.services;


import com.rafwedz.employee.models.Employee;
import com.rafwedz.employee.repositories.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public void save(final Employee employee){ employeeRepository.save(employee); }

    public Employee getById(int emp_id){
       return employeeRepository.getOne(emp_id);
    }
    public void delete(Employee employee){
        employeeRepository.delete(employee);
    }
}
