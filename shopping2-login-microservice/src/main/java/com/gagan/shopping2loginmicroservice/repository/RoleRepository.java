package com.gagan.shopping2loginmicroservice.repository;

import com.gagan.shopping2loginmicroservice.model.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * @author Gagandeep
 * @date 26-04-2020
 * @time 10:00
 */

@Repository
public interface RoleRepository extends CrudRepository<Role, Integer> {
    Role findByRole(@Param("role") String role);
}
