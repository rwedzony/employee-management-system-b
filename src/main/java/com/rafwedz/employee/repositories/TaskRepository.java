package com.rafwedz.employee.repositories;

import com.rafwedz.employee.models.Employee;
import com.rafwedz.employee.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task,Long> {
}
