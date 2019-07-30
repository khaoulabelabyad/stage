package com.project.project.dao;

import com.project.project.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    Customer findByLoginAndPassword(String login, String password);

    Customer findByLogin(String login);
}
