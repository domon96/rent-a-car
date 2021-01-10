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

        saveUser(userRole, "Piotr", "Nowak", "piotr.nowak@gmail.com", "pionow", "pionow");

        saveUser(adminRole, "Ola", "Kowal", "ola.kowal@gmail.com", "olakow", "olakow");
    }

    private User saveUser(UserRole userRole, String firstName, String lastName, String email, String login, String password) {
        return userRepository.save(User.builder()
                .firstName(firstName)
                .lastName(lastName)
                .email(email)
                .login(login)
                .password(passwordEncoder.encode(password))
                .roles(Arrays.asList(userRole))
                .build());
    }
}
