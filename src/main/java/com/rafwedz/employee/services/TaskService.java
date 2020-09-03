package com.rafwedz.employee.services;

import com.rafwedz.employee.models.Task;
import com.rafwedz.employee.repositories.TaskRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TaskService {

    private TaskRepository taskRepository;

    public List<Task> getAllTask(){

        return taskRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
    }
}
