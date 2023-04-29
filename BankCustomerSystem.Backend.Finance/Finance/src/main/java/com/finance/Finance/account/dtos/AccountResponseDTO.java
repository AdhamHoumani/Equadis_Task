package com.finance.Finance.account.dtos;

import com.finance.Finance.enums.CustomEnums;
import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Data
public class AccountResponseDTO {
    private UUID id;
    private UUID customerId;
    private CustomEnums.AccountStatus accountStatus;
    private CustomEnums.AccountType accountType;
    private BigDecimal balance;
    private String currency;
}
