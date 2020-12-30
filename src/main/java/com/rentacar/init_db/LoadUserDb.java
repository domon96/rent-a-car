package com.rentacar.init_db;

import com.rentacar.model.User;
import com.rentacar.model.UserRole;
import com.rentacar.model.enums.RoleType;
import com.rentacar.repository.UserRepository;
import com.rentacar.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Arrays;

@Configuration
public class LoadUserDb implements CommandLineRunner {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        createRoles();
        createUsers();
    }

    private void createRoles() {
        UserRole userRole1 = new UserRole();
        userRole1.setRole(RoleType.ROLE_USER);
        roleRepository.save(userRole1);

        UserRole userRole2 = new UserRole();
        userRole2.setRole(RoleType.ROLE_ADMIN);
        roleRepository.save(userRole2);
    }

    private void createUsers() {
        UserRole userRole = roleRepository.getByRole(RoleType.ROLE_USER);
        UserRole adminRole = roleRepository.getByRole(RoleType.ROLE_ADMIN);

        userRepository.save(User.builder()
                .firstName("Piotr")
                .lastName("Nowak")
                .email("piotr.nowak@gmail.com")
                .login("pionow")
                .password(passwordEncoder.encode("pionow"))
                .roles(Arrays.asList(userRole))
                .build());

        userRepository.save(User.builder()
                .firstName("Ola")
                .lastName("Kowal")
                .email("ola.kowal@gmail.com")
                .login("olakow")
                .password(passwordEncoder.encode("olakow"))
                .roles(Arrays.asList(adminRole))
                .build());
    }
}
