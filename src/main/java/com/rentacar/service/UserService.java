package com.rentacar.service;

import com.rentacar.assembler.UserAssembler;
import com.rentacar.dto.UserDto;
import com.rentacar.model.User;
import com.rentacar.model.UserRole;
import com.rentacar.model.enums.RoleType;
import com.rentacar.repository.RoleRepository;
import com.rentacar.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserAssembler userAssembler;
    private final RoleRepository roleRepository;

    public Long save(UserDto userDto) {
        User user = userAssembler.toEntity(userDto);
        UserRole userRole = roleRepository.getByRole(RoleType.ROLE_USER);
        user.setRoles(Arrays.asList(userRole));
        User savedUser = userRepository.save(user);
        return savedUser.getId();
    }
}
