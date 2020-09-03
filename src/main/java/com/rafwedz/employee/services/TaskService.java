package com.rafwedz.employee.services;

import com.rafwedz.employee.models.Employee;
import com.rafwedz.employee.models.Task;
import com.rafwedz.employee.repositories.TaskRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TaskService {

    private TaskRepository taskRepository;

    public List<Task> getAllTask(){

        return taskRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
    }
    public Optional<Task> getTaskById(Long task_id){
        return taskRepository.findById(task_id);
    }
    public Optional<List<Task>> getEmployeeTask(Long id){
        return taskRepository.findEmployeeTask(id);
    };


}
