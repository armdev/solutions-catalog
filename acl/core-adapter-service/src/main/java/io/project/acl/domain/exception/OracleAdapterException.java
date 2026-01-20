package io.project.acl.domain.exception;

import java.sql.SQLException;

/**
 *
 * @author lenovo
 */
public class OracleAdapterException extends Exception {

    public OracleAdapterException(String failed_to_fetch_customer, SQLException ex) {
    }

}
