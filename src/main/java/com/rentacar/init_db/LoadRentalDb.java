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
        saveRental("Firma A", "a@firma.pl", 123456789L, "Dariusz A");

        saveRental("Firma B", "b@firma.pl", 234567891L, "Michał B");

        saveRental("Firma C", "c@firma.pl", 345678912L, "Ania C");
    }

    private void saveRental(String companyName, String domain, long phone, String owner) {
        rentalRepository.save(Rental.builder()
                .companyName(companyName)
                .domain(domain)
                .phone(phone)
                .owner(owner)
                .build());
    }
}
