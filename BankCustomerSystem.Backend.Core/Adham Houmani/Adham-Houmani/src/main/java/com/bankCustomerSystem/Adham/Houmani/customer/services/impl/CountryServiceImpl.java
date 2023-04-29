package com.bankCustomerSystem.Adham.Houmani.customer.services.impl;

import com.bankCustomerSystem.Adham.Houmani.customer.models.Customer;
import com.bankCustomerSystem.Adham.Houmani.customer.repositories.CustomerRepository;
import com.bankCustomerSystem.Adham.Houmani.customer.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CountryServiceImpl implements CountryService {
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Customer getCustomerById(UUID id) {
        return customerRepository.findById(id).orElse(null);
    }

    @Override
    public Customer addCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer updateCustomer(UUID id, Customer customer) {
        Customer customerdb = customerRepository.findById(id).orElse(null);
        if(customerdb!=null){
            customerdb.setFName(customer.getFName());
            customerdb.setLName(customer.getLName());
            customerdb.setEmail(customer.getEmail());
            customerdb.setPhoneNumber(customer.getPhoneNumber());
            customerdb.setAddress(customer.getAddress());
            return customerRepository.save(customerdb);
        }
        return null;
    }

    @Override
    public void deleteCustomer(UUID id) {
        customerRepository.deleteById(id);
    }
}
