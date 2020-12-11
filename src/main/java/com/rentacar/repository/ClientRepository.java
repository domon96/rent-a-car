package com.rentacar.repository;

import com.rentacar.model.Client;
import org.springframework.data.repository.CrudRepository;

// This will be AUTO IMPLEMENTED by Spring into a Bean called clientRepository

public interface ClientRepository extends CrudRepository<Client, Long> {
}
