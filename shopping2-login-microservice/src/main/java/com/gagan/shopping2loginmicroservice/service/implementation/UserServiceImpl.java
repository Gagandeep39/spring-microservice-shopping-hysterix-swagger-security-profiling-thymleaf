package com.gagan.shopping2loginmicroservice.service.implementation;

import com.gagan.shopping2loginmicroservice.model.Customer;
import com.gagan.shopping2loginmicroservice.model.Role;
import com.gagan.shopping2loginmicroservice.repository.CustomerRepository;
import com.gagan.shopping2loginmicroservice.repository.RoleRepository;
import com.gagan.shopping2loginmicroservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Optional;

/**
 * @author Gagandeep
 * @date 26-04-2020
 * @time 12:24
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Customer findByUsername(String username) {
        Optional<Customer> customer = customerRepository.findCustomerByUsername(username);
        customer.orElseThrow(()-> new UsernameNotFoundException("Username not Found: " + username));
        return customer.get();
    }

    @Override
    public void saveUser(Customer customer) {
//        customer.setPassword(passwordEncoder.encode(user.getPassword()));
        customer.setActive(1);
        customer.setRoles(Collections.singletonList(roleRepository.findByRole("ROLE_USER")));
        customerRepository.save(customer);
    }

    @Override
    public Optional<Customer> checkForOAuthAccount(String username) {
        return customerRepository.findCustomerByUsername(username);
    }


}
