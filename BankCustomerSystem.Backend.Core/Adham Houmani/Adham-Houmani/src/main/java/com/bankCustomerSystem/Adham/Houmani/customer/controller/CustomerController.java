package com.bankCustomerSystem.Adham.Houmani.customer.controller;

import com.bankCustomerSystem.Adham.Houmani.customer.models.Customer;
import com.bankCustomerSystem.Adham.Houmani.customer.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CountryService countryService;

    @GetMapping()
    public List<Customer> getAllCustomers() {
        return countryService.getAllCustomers();
    }

    @GetMapping("/{id}")
    public Customer getCustomerById(@PathVariable UUID id) {
        return countryService.getCustomerById(id);
    }

    @PostMapping()
    public Customer addCustomer(@RequestBody Customer customer) {
        return countryService.addCustomer(customer);
    }

    @PutMapping("/{id}")
    public Customer updateCustomer(@PathVariable UUID id,@RequestBody Customer customer) {
        return countryService.updateCustomer(id,customer);
    }
    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable UUID id) {
        countryService.deleteCustomer(id);
    }
}
