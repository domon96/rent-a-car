package com.rentacar.model;

import com.rentacar.model.enums.City;
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
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long id;

    @Column
    private City city;

    @OneToMany(mappedBy = "department")
    private List<Worker> workers = new ArrayList<>();

    @Column
    @OneToMany
    private List<Car> cars = new ArrayList<>();
}
