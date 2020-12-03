package com.example.demo.web.vm;

import org.springframework.stereotype.Component;

import javax.persistence.Column;
import java.math.BigDecimal;
@Component
public class AccountRequest {
    private String fullName;
    private String phone;
    private String pin;
    private BigDecimal balance;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}
