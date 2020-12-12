package com.rentacar.repository;

import com.rentacar.model.Car;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

// This will be AUTO IMPLEMENTED by Spring into a Bean called clientRepository

@Repository
public interface CarRepository extends CrudRepository<Car, Long> {
}
