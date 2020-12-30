package com.rentacar.repository;

import com.rentacar.model.UserRole;
import com.rentacar.model.enums.RoleType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends CrudRepository<UserRole, Long> {

    UserRole getByRole(RoleType roleType);
}
