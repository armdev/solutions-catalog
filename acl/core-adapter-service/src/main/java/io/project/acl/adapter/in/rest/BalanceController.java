/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.project.acl.adapter.in.rest;

import io.project.acl.application.BalanceInquiryService;
import io.project.acl.domain.dto.BalanceResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v2/accounts")
public class BalanceController {

    private final BalanceInquiryService balanceInquiryService;

    public BalanceController(BalanceInquiryService balanceInquiryService) {
        this.balanceInquiryService = balanceInquiryService;
    }

    @GetMapping("/{accountId}/balance")
    public BalanceResponse getBalance(@PathVariable String accountId) {
        return balanceInquiryService.getBalance(accountId);
    }
}