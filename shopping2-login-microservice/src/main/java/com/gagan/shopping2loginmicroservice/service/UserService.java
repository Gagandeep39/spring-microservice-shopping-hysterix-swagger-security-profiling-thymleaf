package com.gagan.shopping2loginmicroservice.service;

import com.gagan.shopping2loginmicroservice.model.Customer;

import java.util.Optional;

/**
 * @author Gagandeep
 * @date 26-04-2020
 * @time 12:22
 */
public interface UserService {
    public Customer findByUsername(String username);
    public void saveUser(Customer customer);
    public Optional<Customer> checkForOAuthAccount(String username);
}
