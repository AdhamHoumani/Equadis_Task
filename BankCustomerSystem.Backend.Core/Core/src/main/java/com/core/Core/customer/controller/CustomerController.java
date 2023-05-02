package com.core.Core.customer.controller;

import com.core.Core.common.ApiResponse;
import com.core.Core.customer.dtos.CustomerDTO;
import com.core.Core.customer.services.CustomerService;
import com.core.Core.enums.ApiResponseEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.UUID;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping()
    public ApiResponse getAllCustomers() {
        try
        {
            return customerService.getAllCustomers();
        }
        catch (Exception ex)
        {
            return new ApiResponse(ApiResponseEnum.EXCEPTION.getCode(), null,ex.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ApiResponse getCustomerById(@PathVariable UUID id) {
        try
        {
            return customerService.getCustomerById(id);
        }
        catch (Exception ex)
        {
            return new ApiResponse(ApiResponseEnum.EXCEPTION.getCode(), null,ex.getMessage());
        }
    }

    @PostMapping()
    public ApiResponse addCustomer(@RequestBody CustomerDTO customer) {
        try
        {
            return customerService.addCustomer(customer);
        }
        catch (Exception ex)
        {
            return new ApiResponse(ApiResponseEnum.EXCEPTION.getCode(), null,ex.getMessage());
        }
    }

    @PutMapping()
    public ApiResponse updateCustomer(@RequestBody CustomerDTO customer) {
        try
        {
            return customerService.updateCustomer(customer);
        }
        catch (Exception ex)
        {
            return new ApiResponse(ApiResponseEnum.EXCEPTION.getCode(), null,ex.getMessage());
        }
    }
    @DeleteMapping("/{id}")
    public ApiResponse deleteCustomer(@PathVariable UUID id) {
        try
        {
            return customerService.deleteCustomer(id);
        }
        catch (Exception ex)
        {
            return new ApiResponse(ApiResponseEnum.EXCEPTION.getCode(), null,ex.getMessage());
        }

    }
}
