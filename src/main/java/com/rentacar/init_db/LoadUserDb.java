package com.rentacar.init_db;

import com.rentacar.model.Client;
import com.rentacar.model.UserRole;
import com.rentacar.model.Worker;
import com.rentacar.model.enums.JobTitle;
import com.rentacar.model.enums.RoleType;
import com.rentacar.repository.ClientRepository;
import com.rentacar.repository.UserRoleRepository;
import com.rentacar.repository.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Arrays;

@Configuration
public class LoadUserDb implements CommandLineRunner {

    @Autowired
    private UserRoleRepository userRoleRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private WorkerRepository workerRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        createRoles();
        createClients();
        createWorkers();
    }

    private void createRoles() {
        UserRole userRole1 = new UserRole();
        userRole1.setRole(RoleType.USER);
        userRoleRepository.save(userRole1);

        UserRole userRole2 = new UserRole();
        userRole2.setRole(RoleType.ADMIN);
        userRoleRepository.save(userRole2);
    }

    private void createClients() {
        UserRole userRole = userRoleRepository.getByRole(RoleType.USER);
        UserRole adminRole = userRoleRepository.getByRole(RoleType.ADMIN);

        clientRepository.save(Client.builder()
                .firstName("Piotr")
                .lastName("Nowak")
                .email("piotr.nowak@gmail.com")
                .login("pionow")
                .password(passwordEncoder.encode("pionow"))
                .roles(Arrays.asList(userRole))
                .build());

        clientRepository.save(Client.builder()
                .firstName("Ola")
                .lastName("Kowal")
                .email("ola.kowal@gmail.com")
                .login("olakow")
                .password(passwordEncoder.encode("olakow"))
                .roles(Arrays.asList(adminRole))
                .build());
    }

    private void createWorkers() {
        UserRole userRole = userRoleRepository.getByRole(RoleType.USER);
        UserRole adminRole = userRoleRepository.getByRole(RoleType.ADMIN);

        workerRepository.save(Worker.builder()
                .firstName("Damian")
                .lastName("Rydz")
                .jobTitle(JobTitle.WORKER)
                .login("damryd")
                .password(passwordEncoder.encode("damryd"))
                .roles(Arrays.asList(userRole))
                .build());

        workerRepository.save(Worker.builder()
                .firstName("Maks")
                .lastName("Nowy")
                .jobTitle(JobTitle.MANAGER)
                .login("maknow")
                .password(passwordEncoder.encode("maknow"))
                .roles(Arrays.asList(userRole))
                .build());
    }
}
