package com.rafwedz.employee.controllers;


import com.rafwedz.employee.models.Event;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/events")
@PreAuthorize("hasRole('USER')")
public class DaysOffController {
    private List<Event> events;
    @GetMapping("")
    public List<Event> workScheduleIndex(Model model){
        events=new ArrayList<>();
        this.events.add(new Event("pierwszetitle","pierwszename"));
        this.events.add(new Event("drugietitle","drugiename"));
           return events;
    }
}
