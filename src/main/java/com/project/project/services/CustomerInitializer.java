package com.project.project.services;

import com.project.project.dao.CustomerRepository;
import com.project.project.entities.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

public class CustomerInitializer implements Initializer {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void init() {
        Customer customer = new Customer();
        customer.setEmail("john@gmail.com");
        customer.setFirstName("John");
        customer.setLastName("Doe");
        customer.setLogin("jdoe");
        customer.setPassword(passwordEncoder.encode("pass"));
        customerRepository.save(customer);
    }
}
