package com.core.Core.customer.services.impl;

import com.core.Core.common.ApiMessageDTO;
import com.core.Core.common.ApiResponse;
import com.core.Core.common.CommonUtils;
import com.core.Core.common.DataValidationRes;
import com.core.Core.customer.dtos.CustomerDTO;
import com.core.Core.customer.models.Customer;
import com.core.Core.customer.repositories.CustomerRepository;
import com.core.Core.customer.services.CustomerService;
import com.core.Core.enums.ApiMessageTypeEnum;
import com.core.Core.enums.ApiResponseEnum;
import com.core.Core.localHelpers.DataValidationHelper;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@Slf4j
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ApiResponse getAllCustomers() {
        List<Customer> customers = customerRepository.findAll();
        List<CustomerDTO> customerDTOS = CommonUtils.mapList(customers,CustomerDTO.class);
        return new ApiResponse(ApiResponseEnum.SUCCESS.getCode(),customerDTOS);
    }

    @Override
    public ApiResponse getCustomerById(UUID id) {
        Customer customer = customerRepository.findById(id).orElse(null);
        CustomerDTO customerDTO = new CustomerDTO();
        BeanUtils.copyProperties(customer,customerDTO,CommonUtils.getNullPropertyNames(customerDTO));
        modelMapper.map(customer,customerDTO);
        return new ApiResponse(ApiResponseEnum.SUCCESS.getCode(),customer);
    }

    @Override
    public ApiResponse addCustomer(CustomerDTO customerDTO) {
        List<ApiMessageDTO> messageDTOList = new ArrayList<ApiMessageDTO>();
        log.info("Saving customer " + customerDTO.toString());
        DataValidationRes validationRes = DataValidationHelper.validateCustomerData(customerDTO);
        if(!validationRes.isSuccess()){
            messageDTOList.add(new ApiMessageDTO(ApiMessageTypeEnum.ERROR.getCode(),validationRes.getMessage()));
            return new ApiResponse(ApiResponseEnum.FAILED.getCode(), null,messageDTOList);
        }
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDTO,customer,CommonUtils.getNullPropertyNames(customerDTO));
        modelMapper.map(customerDTO,customer);
        Customer savedCustomer = customerRepository.save(customer);
        customerDTO.setId(savedCustomer.getId());
        messageDTOList.add(new ApiMessageDTO(ApiMessageTypeEnum.SUCCESS.getCode(),"Added Successfully!"));
        return new ApiResponse(ApiResponseEnum.SUCCESS.getCode(), customerDTO,messageDTOList);
    }
    @Override
    public ApiResponse updateCustomer(CustomerDTO customerDTO) {
        List<ApiMessageDTO> messageDTOList = new ArrayList<ApiMessageDTO>();
        Customer customerdb = customerRepository.findById(customerDTO.getId()).orElse(null);
        if(customerdb == null){
            messageDTOList.add(new ApiMessageDTO(ApiMessageTypeEnum.ERROR.getCode(),"Entity Not Found"));
            return new ApiResponse(ApiResponseEnum.FAILED.getCode(), null,messageDTOList);
        }
        customerdb.setFirstName(customerDTO.getFirstName());
        customerdb.setLastName(customerDTO.getLastName());
        customerdb.setEmail(customerDTO.getEmail());
        customerdb.setPhoneNumber(customerDTO.getPhoneNumber());
        customerdb.setAddress(customerDTO.getAddress());
        customerRepository.save(customerdb);
        messageDTOList.add(new ApiMessageDTO(ApiMessageTypeEnum.SUCCESS.getCode(),"Updated Successfully!"));
        return new ApiResponse(ApiResponseEnum.SUCCESS.getCode(), customerDTO, messageDTOList);
    }

    @Override
    public ApiResponse deleteCustomer(UUID id) {
        customerRepository.deleteById(id);
        List<ApiMessageDTO> messageDTOList = new ArrayList<ApiMessageDTO>();
        messageDTOList.add(new ApiMessageDTO(ApiMessageTypeEnum.SUCCESS.getCode(),"Deleted Successfully!"));
        return new ApiResponse(ApiResponseEnum.SUCCESS.getCode(), true,messageDTOList);
    }
}
