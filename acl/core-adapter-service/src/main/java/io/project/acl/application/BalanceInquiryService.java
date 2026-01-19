package io.project.acl.application;

import io.project.acl.adapter.out.messaging.OutboxPublisher;
import io.project.acl.domain.dto.BalanceResponse;
import io.project.acl.domain.model.BalanceResult;
import io.project.acl.domain.port.AccountPort;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class BalanceInquiryService {

    private final AccountPort accountPort;
    private final OutboxPublisher outboxPublisher;

    public BalanceInquiryService(AccountPort accountPort,
            OutboxPublisher outboxPublisher) {
        this.accountPort = accountPort;
        this.outboxPublisher = outboxPublisher;
    }

    public BalanceResponse getBalance(String accountId) {

        // 1. Call outbound port (Oracle adapter)
        BalanceResult result = accountPort.getBalance(accountId);

        // 2. Publish event (fire-and-forget)
        outboxPublisher.publishBalanceInquiry(accountId);

        // 3. Map domain → response DTO
        return new BalanceResponse(
                accountId,
                result.getAmount(),
                result.getCurrency()
        );
    }
}
