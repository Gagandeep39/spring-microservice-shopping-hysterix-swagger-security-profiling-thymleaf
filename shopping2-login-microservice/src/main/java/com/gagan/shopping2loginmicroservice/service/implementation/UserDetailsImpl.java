package com.gagan.shopping2loginmicroservice.service.implementation;

import com.gagan.shopping2loginmicroservice.model.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Gagandeep
 * @date 26-04-2020
 * @time 10:08
 */

@Service
public class UserDetailsImpl implements UserDetails {

    private String username;
    private String password;
    private boolean isActive;
    private List<GrantedAuthority> authorities;

    UserDetailsImpl(){

    }

    Logger logger = LoggerFactory.getLogger(UserDetailsImpl.class);

    UserDetailsImpl(Customer customer){
        this.username = customer.getUsername();
        this.password = customer.getPassword();
        this.isActive = (1 == customer.getActive());
        List<String> roles = new ArrayList<>();
        customer.getRoles().forEach(role->roles.add(role.getRole()));
        authorities = roles.stream().map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
        logger.info(customer.getUsername());
        logger.info(customer.getPassword());
        logger.info(customer.getRoles().toString());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return isActive;
    }
}
