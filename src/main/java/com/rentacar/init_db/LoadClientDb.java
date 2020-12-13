package com.rentacar.init_db;

import com.rentacar.model.Client;
import com.rentacar.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadClientDb implements CommandLineRunner {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public void run(String... args) throws Exception {
        clientRepository.save(Client.builder()
                .firstName("Piotr")
                .lastName("Nowak")
                .email("piotr.nowak@gmail.com")
                .login("piotnow")
                .password("piotnow")
                .build());

        clientRepository.save(Client.builder()
                .firstName("Ola")
                .lastName("Kowal")
                .email("ola.kowal@gmail.com")
                .login("olakow")
                .password("olakow")
                .build());
    }
}
