package com.rentacar.assembler;

import com.rentacar.dto.UserDto;
import com.rentacar.model.User;
import com.rentacar.model.enums.RoleType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class UserAssembler {

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User toEntity(UserDto userDto) {
        User entity = new User();
        entity.setFirstName(userDto.getFirstName());
        entity.setLastName(userDto.getLastName());
        entity.setEmail(userDto.getEmail());
        entity.setLogin(userDto.getLogin());
        entity.setPassword(passwordEncoder.encode(userDto.getPassword()));

        return entity;
    }
}
