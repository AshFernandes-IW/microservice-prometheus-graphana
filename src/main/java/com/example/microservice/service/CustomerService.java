package com.example.microservice.service;

import java.util.List;
import com.example.microservice.entity.Customer;

public interface CustomerService {

    List<Customer> getCustomers();
    Customer getCustomerById(Long id);

    void saveCustomer(Customer customer);
    void deleteCustomer(Long id);
}