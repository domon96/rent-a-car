package com.rentacar.controller;

import com.rentacar.model.Rental;
import com.rentacar.repository.RentalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/rentals")
public class RentalRestController {

    @Autowired
    private RentalRepository rentalRepository;

    @PostMapping(path = "/add")
    public String addNewRental(
            @RequestParam String companyName,
            @RequestParam String domain,
            @RequestParam Long phone,
            @RequestParam String owner) {
        Rental newRental = new Rental();
        newRental.setCompanyName(companyName);
        newRental.setDomain(domain);
        newRental.setPhone(phone);
        newRental.setOwner(owner);

        rentalRepository.save(newRental);
        return "Saved";
    }

    @GetMapping(path = "/all")
    public Iterable<Rental> getAllRentals() {
        return rentalRepository.findAll();
    }

    @GetMapping(path = "/{id}")
    public Optional<Rental> getRental(@PathVariable Long id) {
        return rentalRepository.findById(id);
    }
}
