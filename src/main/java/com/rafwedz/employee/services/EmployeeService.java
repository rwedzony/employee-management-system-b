package com.rafwedz.employee.services;


import com.rafwedz.employee.models.Employee;
import com.rafwedz.employee.repositories.EmployeeRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
    }


    public long count(){ return employeeRepository.count();
    }

    public void save(final Employee employee){
        employeeRepository.save(employee);
    }



    public Optional<Employee> getEmployeeById(Long emp_id){
       return employeeRepository.findById(emp_id);
    }

    public void deleteEmployeeById(Long emp_id){
       employeeRepository.deleteById(emp_id);
    }

    public void delete(Employee employee){
        employeeRepository.delete(employee);
    }
}
