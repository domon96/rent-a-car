package com.rentacar.init_db;

import com.rentacar.model.Rental;
import com.rentacar.repository.RentalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadRentalDb implements CommandLineRunner {

    @Autowired
    private RentalRepository rentalRepository;

    @Override
    public void run(String... args) throws Exception {
        rentalRepository.save(Rental.builder()
                .companyName("Firma A")
                .domain("a@firma.pl")
                .phone(123456789L)
                .owner("Dariusz A")
                .build());

        rentalRepository.save(Rental.builder()
                .companyName("Firma B")
                .domain("b@firma.pl")
                .phone(234567891L)
                .owner("Michał B")
                .build());

        rentalRepository.save(Rental.builder()
                .companyName("Firma C")
                .domain("c@firma.pl")
                .phone(345678912L)
                .owner("Ania C")
                .build());
    }
}
