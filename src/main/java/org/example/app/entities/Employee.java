package org.example.app.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    private Integer id;
    private String lastName;
    private String firstName;
    private String birthDate;
    private Integer positionId;
    private String positionName;
    private String phone;
    private double salary;


}
