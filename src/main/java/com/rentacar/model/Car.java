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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String brand;

    @Column
    private String model;

    @Column
    @Enumerated(EnumType.STRING)
    private CarBodyType type;

    @Column(name = "production_year")
    private int productionYear;

    @Column
    @Enumerated(EnumType.STRING)
    private PaintColor color;

    @Column
    private int mileage;

    @Column
    @Enumerated(EnumType.STRING)
    private CarStatus status;

    @Column(name = "one_day_price")
    private double oneDayPrice;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;
}
