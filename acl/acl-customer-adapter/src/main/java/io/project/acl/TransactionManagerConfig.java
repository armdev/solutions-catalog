package io.project.acl;

import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.annotation.Configuration;

import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.event.TransactionalEventListener;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
@RequiredArgsConstructor
@EnableTransactionManagement
public class TransactionManagerConfig {

    @TransactionalEventListener(classes = Exception.class)
    public void consume(ApplicationEvent applicationEvent) {
        log.info("TransactionalEventListener : " + applicationEvent);
    }

}
