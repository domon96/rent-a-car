package com.rentacar.repository;

import com.rentacar.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

// This will be AUTO IMPLEMENTED by Spring into a Bean called clientRepository

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
}
