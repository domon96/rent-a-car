package com.rentacar.model;

import com.rentacar.model.enums.JobTitle;
import lombok.*;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table
@Data
@Builder
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
