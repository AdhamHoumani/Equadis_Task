package com.finance.Finance.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CustomEnums {

    @Getter
    @AllArgsConstructor
    public enum AccountStatus {
        ACTIVE("Active"),
        BLOCKED("Blocked"),
        UN_HOLD("Un Hold");
        private final String name;
    }

    @Getter
    @AllArgsConstructor
    public enum AccountType {
        EXTERNAL("External"),
        PAYROLL("Payroll"),
        SAVING("Saving");
        private final String name;
    }
}
