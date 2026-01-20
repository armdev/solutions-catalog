package io.project.acl.application;

import io.project.acl.adapter.out.messaging.OutboxPublisher;
import io.project.acl.domain.dto.CustomerRecord;
import io.project.acl.domain.port.CustomerPort;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@AllArgsConstructor
public class CustomerInquiryService {

    private final CustomerPort customerPort;
    private final OutboxPublisher outboxPublisher;

    public CustomerRecord findCustomerById(Long customerId) {

        CustomerRecord customer = customerPort.findCustomerById(customerId);

        if (customer == null) {
            log.debug("Customer not found by id={}", customerId);
            return null;
        }

        publishInquiry(customer);
        return customer;
    }

    public CustomerRecord findCustomerBySsn(String ssn) {

        CustomerRecord customer = customerPort.findCustomerBySsn(ssn);

        if (customer == null) {
            log.debug("Customer not found by ssn={}", ssn);
            return null;
        }

        publishInquiry(customer);
        return customer;
    }

    public CustomerRecord findCustomerByEmail(String email) {

        CustomerRecord customer = customerPort.findCustomerByEmail(email);

        if (customer == null) {
            log.debug("Customer not found by email={}", email);
            return null;
        }

        publishInquiry(customer);
        return customer;
    }

    /* -------------------- internal -------------------- */

    private void publishInquiry(CustomerRecord customer) {
        try {
            outboxPublisher.publishCustomerInquiry(customer.getCustomerId());
        } catch (Exception ex) {
            // Important: inquiry failure must NOT affect read path
            log.warn(
                "Failed to publish customer inquiry event, customerId={}",
                customer.getCustomerId(),
                ex
            );
        }
    }
}
