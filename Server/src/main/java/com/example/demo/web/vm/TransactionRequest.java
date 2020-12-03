package com.example.demo.web.vm;

import org.springframework.stereotype.Component;

import javax.persistence.Column;
import java.math.BigDecimal;

@Component
public class TransactionRequest {
    private String cardNo1;
    private String cardNo2;
    private TransactionType type;
    private BigDecimal money;

    public String getCardNo1() {
        return cardNo1;
    }

    public void setCardNo1(String cardNo1) {
        this.cardNo1 = cardNo1;
    }

    public String getCardNo2() {
        return cardNo2;
    }

    public void setCardNo2(String cardNo2) {
        this.cardNo2 = cardNo2;
    }

    public TransactionType getType() {
        return type;
    }

    public void setType(TransactionType type) {
        this.type = type;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }
}
