package com.rafwedz.employee.controllers;

import com.rafwedz.employee.utils.LoggedUserDetails;
import com.rafwedz.employee.annotations.Logging;
import com.rafwedz.employee.models.Employee;
import com.rafwedz.employee.services.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.security.RolesAllowed;


@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/employees")
public class EmployeeController {

    private final EmployeeService employeeService;


    //@GetMapping("")
    //@Logging
    public String employeeList(Model model) {
        SecurityContext context= SecurityContextHolder.getContext();
        model.addAttribute("employees", employeeService.getAllEmployees());
        model.addAttribute("message",LoggedUserDetails.getLoggedUserName());
        return "employees/employees";
    }

    //@RolesAllowed("ADMIN")
    //@GetMapping("/add")
    public String showEmployeeForm(Model model) {
        Employee employee=new Employee();
        model.addAttribute("employee",employee);
        model.addAttribute("message",LoggedUserDetails.getLoggedUserName());
        return "employees/employee_form";

    }
    //@PostMapping("/save")
    public String save(@ModelAttribute Employee employee) {
        if (employee.getId() == 0) {
            employeeService.save(employee);
        } else {
            Employee empTemp = employeeService.getById(employee.getId());
            empTemp.setFirstName(employee.getFirstName());
            empTemp.setLastName(employee.getLastName());
            empTemp.setEmail(employee.getEmail());
            empTemp.setRole(employee.getRole());
            empTemp.setCurrentMonthWorkingHours(employee.getCurrentMonthWorkingHours());
            employeeService.save(empTemp);
        }

        return "redirect:/employees";
    }

    //@PostMapping(value = "/edit")
    public String edit(@RequestParam(value = "emp_id") int emp_id, Model model) {

        Employee employee = employeeService.getById(emp_id);

        model.addAttribute("employee",employee);
        model.addAttribute("message",LoggedUserDetails.getLoggedUserName());
        return "employees/employee_form";
        //return new ModelAndView("employees/employee_form","employee",employee);
    }


    //@PostMapping("/delete")
    public String delete(@RequestParam(value="emp_id") int emp_id) {
        Employee employee=employeeService.getById(emp_id);
        employeeService.delete(employee);
        return "redirect:/employees";
    }





}
