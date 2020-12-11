package com.rentacar.model;

import lombok.*;

import javax.persistence.*;
import java.awt.*;

@Entity
@Table
@ToString
@EqualsAndHashCode
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String brand;

    @Column
    private String model;

    @Column
    private CarBodyType type;

    @Column
    private int productionYear;

    @Column
    private Color color;

    @Column
    private int mileage;

    @Column
    private CarStatus status;

    @Column
    private double oneDayPrice;
}
