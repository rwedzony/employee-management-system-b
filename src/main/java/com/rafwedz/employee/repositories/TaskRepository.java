package com.rafwedz.employee.repositories;

import com.rafwedz.employee.models.Employee;
import com.rafwedz.employee.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TaskRepository extends JpaRepository<Task,Long> {

    @Query(value = "select t from Task t where t.employee.id = ?1")
    Optional<Task> findEmployeeTask(String s);
}
