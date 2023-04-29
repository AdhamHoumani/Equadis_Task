package com.bankCustomerSystem.Adham.Houmani.customer.services;

import com.bankCustomerSystem.Adham.Houmani.customer.models.Customer;

import java.util.List;
import java.util.UUID;

public interface CountryService {
    List<Customer> getAllCustomers();
    Customer getCustomerById(UUID id);
    Customer addCustomer(Customer customer);
    Customer updateCustomer(UUID id,Customer customer);
    void deleteCustomer(UUID id);
}
