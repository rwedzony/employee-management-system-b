package com.rafwedz.employee.controllers;

import com.rafwedz.employee.models.Employee;
import com.rafwedz.employee.models.Task;
import com.rafwedz.employee.services.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityExistsException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

    @GetMapping("/unassigned")
    public List<Task> notAssignedTaskList(){
        System.out.println("get all unassigned task");
        List<Task> unAssignedTasks =new ArrayList<>();
        unAssignedTasks=taskService.getAllUnassignedTasks();
        return unAssignedTasks;

    }

    @GetMapping("/assigned")
    public List<Task> AssignedTaskList(){
        System.out.println("get all assigned task");
        List<Task> AssignedTasks =new ArrayList<>();
        AssignedTasks=taskService.getAllassignedTasks();
        return AssignedTasks;

    }

    @GetMapping("/{task_id}")
    public Task getTaskById(@PathVariable(value= "task_id") String task_id){
        System.out.println("GET Task by ID function");
        return taskService.getTaskById(Long.parseLong(task_id)).orElseThrow(EntityExistsException::new);
    }

    @PatchMapping("/{task_id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT, reason = "Task partial updated!")
    public void updateTask(@RequestBody Map<String, String> updates, @PathVariable(value="task_id") String task_id) {
        Task task=taskService.getTaskById(Long.parseLong(task_id)).orElseThrow(EntityExistsException::new);
        task.setStatus(updates.get("status"));
        this.taskService.save(task);
    }


}
