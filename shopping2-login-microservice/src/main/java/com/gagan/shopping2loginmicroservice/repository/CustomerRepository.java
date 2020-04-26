package com.gagan.shopping2loginmicroservice.repository;

import com.gagan.shopping2loginmicroservice.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author Gagandeep
 * @date 26-04-2020
 * @time 10:03
 */

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    @Query("SELECT c FROM Customer c where c.username=?1")
    public Optional<Customer> findCustomerByUsername(String username);
//    Test it whe you are free :D
//    public Customer findByUsername(@Param("username") String username);
}
