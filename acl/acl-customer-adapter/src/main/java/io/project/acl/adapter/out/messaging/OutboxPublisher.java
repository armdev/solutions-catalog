/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.project.acl.adapter.out.messaging;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 *
 * @author armen_arzumanyan
 */
@Component
@Slf4j
public class OutboxPublisher {

    public void publishCustomerInquiry(Long customerId) {

        // Simulate outbox write
        log.info(
                "Outbox event stored: request for customerId " + customerId
        );
    }
}
