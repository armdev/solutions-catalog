package io.project.acl.application;

import io.project.acl.adapter.out.messaging.OutboxPublisher;
import io.project.acl.domain.dto.CustomerDto;
import io.project.acl.domain.port.CustomerPort;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CustomerInquiryService {

    private final CustomerPort customerPort;
    private final OutboxPublisher outboxPublisher;

    public CustomerInquiryService(CustomerPort customerPort,
            OutboxPublisher outboxPublisher) {
        this.customerPort = customerPort;
        this.outboxPublisher = outboxPublisher;
    }

    public CustomerDto findCustomerById(Long id) {

        // 1. Call outbound port (Oracle adapter)
        Optional<CustomerDto> record = customerPort.findCustomerById(id);
        if (!record.isEmpty()) {

            CustomerDto get = record.get();
            outboxPublisher.publishBalanceInquiry(get.getCustomer());

            return get;
        }

        // 2. Publish event (fire-and-forget)
        // 3. Map domain → response DTO
        return null;

    }
}
