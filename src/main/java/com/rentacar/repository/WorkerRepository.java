package com.rentacar.repository;

import com.rentacar.model.Worker;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

// This will be AUTO IMPLEMENTED by Spring into a Bean called clientRepository

@Repository
public interface WorkerRepository extends CrudRepository<Worker, Long> {
}
