package com.finance.Finance.account.controllers;

import com.finance.Finance.account.dtos.AccountRequestDTO;
import com.finance.Finance.account.models.Account;
import com.finance.Finance.account.services.AccountService;
import com.finance.Finance.common.RestCommonResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    RestCommonResponse saveNew(@RequestBody AccountRequestDTO accountRequestDTO) {
        return accountService.saveNew(accountRequestDTO);
    }
}
