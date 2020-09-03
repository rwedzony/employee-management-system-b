package com.rafwedz.employee.controllers;

import com.rafwedz.employee.models.Employee;
import com.rafwedz.employee.models.Task;
import com.rafwedz.employee.services.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityExistsException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/tasks")
@CrossOrigin
public class TaskController {

    private final TaskService taskService;

    @GetMapping("")
    public List<Task> taskList(){
        System.out.println("get ALL TASKS");
        List<Task> tasks =new ArrayList<>();
        tasks=taskService.getAllTask();
        return tasks;

    }

    @GetMapping("/{task_id}")
    public Task getTaskById(@PathVariable(value= "task_id") String task_id){
        System.out.println("GET Task by ID function");
        return taskService.getTaskById(Long.parseLong(task_id)).orElseThrow(EntityExistsException::new);
    }


}
