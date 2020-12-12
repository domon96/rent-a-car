package com.rentacar.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
@Data
@NoArgsConstructor
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long id;

    @Column
    private City city;

    @Column
    @OneToMany
    private List<Worker> workers = new ArrayList<>();

    @Column
    @OneToMany
    private List<Car> cars = new ArrayList<>();
}
