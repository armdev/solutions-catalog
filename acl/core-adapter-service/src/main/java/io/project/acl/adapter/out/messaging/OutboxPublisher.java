/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.project.acl.adapter.out.messaging;

import org.springframework.stereotype.Component;

/**
 *
 * @author armen_arzumanyan
 */
@Component
public class OutboxPublisher {

    public void publishBalanceInquiry(String accountId) {

        // Simulate outbox write
        System.out.println(
            "Outbox event stored: BALANCE_INQUIRY for account " + accountId
        );
    }
}
