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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    @Enumerated(EnumType.STRING)
    private City city;

    @OneToMany(mappedBy = "department")
    private List<Worker> workers = new ArrayList<>();

    @OneToMany(mappedBy = "department")
    private List<Car> cars = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "rental_id")
    private Rental rental;
}
