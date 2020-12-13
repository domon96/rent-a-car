package com.rentacar.model;

import com.rentacar.model.enums.JobTitle;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class Worker extends User {

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private JobTitle jobTitle;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;
}
