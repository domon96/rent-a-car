package com.rentacar.model.enums;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table
@Data
@NoArgsConstructor
public class UserRole {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    @Enumerated(EnumType.STRING)
    private RoleType type;
}
