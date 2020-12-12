package com.rentacar.repository;

import com.rentacar.model.Rental;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

// This will be AUTO IMPLEMENTED by Spring into a Bean called rentalRepository

@Repository
public interface RentalRepository extends CrudRepository<Rental, Long> {
}
