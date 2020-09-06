package com.rafwedz.employee.controllers;

import com.rafwedz.employee.dto.TaskDto;
import com.rafwedz.employee.models.Employee;
import com.rafwedz.employee.models.Task;
import com.rafwedz.employee.services.EmployeeService;
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
    private final EmployeeService employeeService;

    @GetMapping("")
    public List<Task> taskList(){
        System.out.println("get ALL TASKS");
        List<Task> tasks =new ArrayList<>();
        tasks=taskService.getAllTask();
        return tasks;

    }

    @GetMapping("/tasksdto")
    public List<TaskDto> getTaskDto(){
        List<TaskDto> TasksDto =new ArrayList<>();
        TasksDto=taskService.getTasksDtos();
        return TasksDto;

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

    @PostMapping
    public void createTask(@RequestBody Task task) {
       // System.out.println("task desc");
       System.out.println("create task function");
        taskService.save(task);
    }

    @PatchMapping("/{task_id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT, reason = "Task partial updated!")
    public void updateTask(@RequestBody Map<String, String> updates, @PathVariable(value="task_id") String task_id) {
        Task task=taskService.getTaskById(Long.parseLong(task_id)).orElseThrow(EntityExistsException::new);

        if(updates.containsKey("status")){
            task.setStatus(updates.get("status"));
        }
        if(updates.containsKey("assigned")){
           task.setEmployee(null);
        }
        if(updates.containsKey("employeeId")){
            Employee employee = employeeService.getEmployeeById(Long.parseLong(updates.get("employeeId"))).orElseThrow(EntityExistsException::new);
            task.setEmployee(employee);
        }

        this.taskService.save(task);
    }
    @DeleteMapping(value="/{task_id}")
    public void delete(@PathVariable(value="task_id") String task_id) {
        System.out.println("delete function");
        taskService.deleteTaskById(Long.parseLong(task_id));
    }


}
