package com.rafwedz.employee.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NonNull
    private String firstName;
    @NonNull
    private String lastName;
    @NonNull
    private String email;
    @NonNull
    private String password;
    private int salary;
    @NonNull
    private String empAuthLevel;
    @NonNull
    private String occupation;
    @NonNull
    private int currentMonthWorkingHours;
    private int remainingDayOffs;

    public Employee(Employee employee){
        this.id=employee.getId();
        this.firstName=employee.getFirstName();
        this.lastName=employee.getLastName();
        this.email=employee.getEmail();
        this.password=employee.getPassword();
        this.salary=employee.getSalary();
        this.occupation =employee.getOccupation();
        this.currentMonthWorkingHours=employee.getCurrentMonthWorkingHours();
        this.empAuthLevel=employee.getEmpAuthLevel();
        this.remainingDayOffs=employee.getRemainingDayOffs();
    }


//    public char getLastNameFirstChar(){
//        return lastName.charAt(0);
//    }

}
