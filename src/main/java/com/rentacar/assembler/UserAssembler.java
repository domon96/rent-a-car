package com.rentacar.assembler;

import com.rentacar.dto.UserDto;
import com.rentacar.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserAssembler {

    private final PasswordEncoder passwordEncoder;

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
