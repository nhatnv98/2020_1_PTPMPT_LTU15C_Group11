package com.example.demo.web.vm;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum TransactionType {
    @JsonProperty(value = "Withdraw")
    WITHDRAW,
    @JsonProperty(value = "Deposit")
    DEPOSIT,
    @JsonProperty(value = "Transfer")
    TRANSFER
}
