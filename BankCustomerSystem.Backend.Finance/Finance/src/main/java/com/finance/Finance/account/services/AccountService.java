package com.finance.Finance.account.services;

import com.finance.Finance.account.dtos.AccountRequestDTO;
import com.finance.Finance.account.models.Account;
import com.finance.Finance.common.RestCommonResponse;

public interface AccountService {
    RestCommonResponse saveNew(AccountRequestDTO accountRequestDTO);
}
