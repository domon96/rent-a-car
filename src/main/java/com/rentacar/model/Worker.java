package com.rentacar.model;

import com.rentacar.model.enums.JobTitle;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table
@Data
@NoArgsConstructor
public class Worker {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long id;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private JobTitle jobTitle;

    @Column
    @ManyToOne
    private Department department;
}
