package com.example.microservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.microservice.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}