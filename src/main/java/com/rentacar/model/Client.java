package com.rentacar.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class Client extends User {

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private String email;
}
