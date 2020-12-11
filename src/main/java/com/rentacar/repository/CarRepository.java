package com.rentacar.repository;

import com.rentacar.model.Car;
import org.springframework.data.repository.CrudRepository;

// This will be AUTO IMPLEMENTED by Spring into a Bean called clientRepository

public interface CarRepository extends CrudRepository<Car, Long> {
}
