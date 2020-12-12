package com.rentacar.model;

import com.rentacar.model.enums.CarBodyType;
import com.rentacar.model.enums.CarStatus;
import com.rentacar.model.enums.PaintColor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
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
    private PaintColor color;

    @Column
    private int mileage;

    @Column
    private CarStatus status;

    @Column
    private double oneDayPrice;
}
