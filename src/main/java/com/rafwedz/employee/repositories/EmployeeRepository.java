package com.rafwedz.employee.repositories;

import com.rafwedz.employee.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    @Query("select e from Employee e " +
            "where lower(e.firstName) like lower(concat('%', :searchTerm, '%')) " +
            "or lower(e.lastName) like lower(concat('%', :searchTerm, '%'))") //
    List<Employee> search(@Param("searchTerm") String searchTerm); //

    @Query(value = "select e from Employee e where e.email = ?1")
    Optional<Employee> findUserByUsername(String s);
}
