package com.rentacar.initDb;

import com.rentacar.model.Client;
import com.rentacar.repository.ClientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadClientDb {

    @Bean
    CommandLineRunner clientInitDataBase(ClientRepository clientRepository) {

        return args -> {
            clientRepository.save(Client.builder()
                    .firstName("Piotr")
                    .lastName("Nowak")
                    .email("piotr.nowak@gmail.com")
                    .build());

            clientRepository.save(Client.builder()
                    .firstName("Ola")
                    .lastName("Kowal")
                    .email("ola.kowal@gmail.com")
                    .build());
        };
    }
}
