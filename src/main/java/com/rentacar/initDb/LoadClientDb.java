package com.rentacar.initDb;

import com.rentacar.model.Client;
import com.rentacar.repository.ClientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadClientDb {

    @Bean
    CommandLineRunner initDataBase (ClientRepository clientRepository) {

        return args -> {
            clientRepository.save(new Client("Piotr","Nowak","piotr.nowak@gmail.com"));
            clientRepository.save(new Client("Ola","Kowalska","ola.kowalska@gmail.com"));
        };
    }
}
