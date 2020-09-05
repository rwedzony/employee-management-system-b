package com.rafwedz.employee.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NonNull
    private String description;

    @NonNull
    private String status;

    @NonNull
    @Basic
    private LocalDate startDate;

    @NonNull
    @Basic
    private LocalDate endDate;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="employee_id")
    private Employee employee;

}
