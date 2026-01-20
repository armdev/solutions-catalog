package io.project.acl.domain.port;

import io.project.acl.domain.dto.CustomerRecord;

/**
 *
 * @author armen_arzumanyan
 */
public interface CustomerPort {

    CustomerRecord findCustomerById(Long customerId);

    CustomerRecord findCustomerBySsn(String ssn);

    CustomerRecord findCustomerByEmail(String email);
}
