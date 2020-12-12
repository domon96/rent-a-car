package com.rentacar.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Rental {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private String companyName;

    @Column
    private String domain;

    @Column
    private Long phone;

    @Column
    private String owner;

    @Column
    @OneToMany
    private final List<Department> departments = new ArrayList<>();

    // add avatar?
}
