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
    @NonNull
    private String empAuthLevel;
    @NonNull
    private String role;
    @NonNull
    private int currentMonthWorkingHours;

    public Employee(Employee employee){
        this.id=employee.getId();
        this.firstName=employee.getFirstName();
        this.lastName=employee.getLastName();
        this.email=employee.getEmail();
        this.password=employee.getPassword();
        this.role=employee.getRole();
        this.currentMonthWorkingHours=employee.getCurrentMonthWorkingHours();
        this.empAuthLevel=employee.empAuthLevel;
    }


//    public char getLastNameFirstChar(){
//        return lastName.charAt(0);
//    }

}
