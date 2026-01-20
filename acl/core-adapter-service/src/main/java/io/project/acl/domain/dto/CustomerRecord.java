package io.project.acl.domain.dto;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 *
 * @author lenovo
 */
@Data
@AllArgsConstructor
public class CustomerRecord implements Serializable {

    private final Long customerId;
    private final String customer;
    private final String email;
    private final String nameE;
    private final String personNum;

}
