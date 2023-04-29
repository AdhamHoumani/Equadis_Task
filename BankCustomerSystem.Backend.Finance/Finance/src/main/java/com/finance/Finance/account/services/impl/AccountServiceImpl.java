package com.finance.Finance.account.services.impl;

import com.finance.Finance.account.CommonUtils;
import com.finance.Finance.account.dtos.AccountRequestDTO;
import com.finance.Finance.account.dtos.AccountResponseDTO;
import com.finance.Finance.account.models.Account;
import com.finance.Finance.account.repositories.AccountRepository;
import com.finance.Finance.account.services.AccountService;
import com.finance.Finance.common.RestCommonResponse;
import com.finance.Finance.exception.BadRequestException;
import com.finance.Finance.feign.CoreApiClient;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AccountServiceImpl implements AccountService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private CoreApiClient coreApiClient;


    @Override
    public RestCommonResponse saveNew(AccountRequestDTO accountRequestDTO) {
        log.info("Saving account " + accountRequestDTO.toString());
        validateAccountOnSave(accountRequestDTO);
        //CustomerResponseDTO customer = checkValidatedCustomer(cityRequestDTO.getCountryId());
        Account account = new Account();
        BeanUtils.copyProperties(accountRequestDTO, account, com.finance.Finance.account.CommonUtils.getNullPropertyNames(accountRequestDTO));
        modelMapper.map(accountRequestDTO, account);
        //account.setCustomerId(customer.getId);
        Account savedAccount = null;
        try {
            savedAccount = accountRepository.save(account);
        } catch (Exception e) {
            log.error("asaks",e);
            throw new BadRequestException("Error occurred", "Error in saving account", 400);
        }
        RestCommonResponse response = new RestCommonResponse(true, modelMapper.map(savedAccount, AccountResponseDTO.class));
        response.setMessage("Solved");
        return response;
    }

    private void validateAccountOnSave(AccountRequestDTO accountRequestDTO) {
        if (CommonUtils.isEmpty(accountRequestDTO.getCurrency())) {
            throw new BadRequestException("Error occurred", "Error in saving account", 400);
        }

    }
//    private CustomerResponseDTO checkValidatedCustomer(UUID countryId) {
   // coreApiClient.getCustomerById(UUID.fromString("ef5e0863-84c8-4299-a78a-878c55fec665"));
//        log.info("Retrieving country by id : ".concat(countryId.toString()));
//        return country;
//    }

}
