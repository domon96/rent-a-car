package com.rentacar.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table
@Data
@Builder
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
