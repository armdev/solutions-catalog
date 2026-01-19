/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.project.acl.domain.dto;

import java.math.BigDecimal;

public class BalanceResponse {

    private final String accountId;
    private final BigDecimal balance;
    private final String currency;

    public BalanceResponse(String accountId,
                           BigDecimal balance,
                           String currency) {
        this.accountId = accountId;
        this.balance = balance;
        this.currency = currency;
    }

    public String getAccountId() {
        return accountId;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public String getCurrency() {
        return currency;
    }
}
