package com.finance.Finance.account.dtos;

import com.finance.Finance.enums.CustomEnums;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.UUID;

@Data
public class AccountRequestDTO {
    private UUID customerId;
    private CustomEnums.AccountStatus accountStatus;
    private CustomEnums.AccountType accountType;
    private BigDecimal balance;
    private String currency;
}
