package io.project.acl.adapter.out.oracle;

import io.project.acl.domain.dto.CustomerRecord;
import io.project.acl.domain.port.CustomerPort;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import javax.sql.DataSource;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class CustomerOracleAdapter implements CustomerPort {

    private static final String PROC_GET_BY_ID =
            "{ call IBANK.get_customer_by_id(?, ?, ?, ?, ?) }";

    private static final String PROC_GET_BY_PERSONNUM =
            "{ call IBANK.get_customer_by_personnum(?, ?, ?, ?, ?) }";

    private static final String PROC_GET_BY_EMAIL =
            "{ call IBANK.get_customer_by_email(?, ?, ?, ?, ?) }";

    private final DataSource dataSource;

    @Override
    public CustomerRecord findCustomerById(Long customerId) {
        try (Connection con = dataSource.getConnection();
             CallableStatement cs = con.prepareCall(PROC_GET_BY_ID)) {

            cs.setLong(1, customerId);

            cs.registerOutParameter(2, Types.VARCHAR); // customer
            cs.registerOutParameter(3, Types.VARCHAR); // email
            cs.registerOutParameter(4, Types.VARCHAR); // name_e
            cs.registerOutParameter(5, Types.VARCHAR); // personnum

            cs.execute();

            return mapCustomer(
                    customerId,
                    cs.getString(2),
                    cs.getString(3),
                    cs.getString(4),
                    cs.getString(5)
            );

        } catch (SQLException ex) {
            throw new IllegalStateException(
                    "Oracle call failed: get_customer_by_id, customerId=" + customerId, ex);
        }
    }

    @Override
    public CustomerRecord findCustomerBySsn(String ssn) {
        try (Connection con = dataSource.getConnection();
             CallableStatement cs = con.prepareCall(PROC_GET_BY_PERSONNUM)) {

            cs.setString(1, ssn);

            cs.registerOutParameter(2, Types.BIGINT);  // customerId
            cs.registerOutParameter(3, Types.VARCHAR); // customer
            cs.registerOutParameter(4, Types.VARCHAR); // email
            cs.registerOutParameter(5, Types.VARCHAR); // name_e

            cs.execute();

            Long customerId = cs.getLong(2);
            if (cs.wasNull()) {
                return null;
            }

            return mapCustomer(
                    customerId,
                    cs.getString(3),
                    cs.getString(4),
                    cs.getString(5),
                    ssn
            );

        } catch (SQLException ex) {
            throw new IllegalStateException(
                    "Oracle call failed: get_customer_by_personnum, ssn=" + ssn, ex);
        }
    }

    @Override
    public CustomerRecord findCustomerByEmail(String email) {
        try (Connection con = dataSource.getConnection();
             CallableStatement cs = con.prepareCall(PROC_GET_BY_EMAIL)) {

            cs.setString(1, email);

            cs.registerOutParameter(2, Types.BIGINT);  // customerId
            cs.registerOutParameter(3, Types.VARCHAR); // customer
            cs.registerOutParameter(4, Types.VARCHAR); // personnum
            cs.registerOutParameter(5, Types.VARCHAR); // name_e

            cs.execute();

            Long customerId = cs.getLong(2);
            if (cs.wasNull()) {
                return null;
            }

            return mapCustomer(
                    customerId,
                    cs.getString(3),
                    email,
                    cs.getString(5),
                    cs.getString(4)
            );

        } catch (SQLException ex) {
            throw new IllegalStateException(
                    "Oracle call failed: get_customer_by_email, email=" + email, ex);
        }
    }

    /* -------------------- mapping -------------------- */

    private CustomerRecord mapCustomer(
            Long customerId,
            String customer,
            String email,
            String nameE,
            String personNum) {

        // Oracle NO_DATA_FOUND → all OUT params NULL
        if (customer == null && email == null
                && nameE == null && personNum == null) {
            return null;
        }

        return new CustomerRecord(
                customerId,
                customer,
                email,
                nameE,
                personNum
        );
    }
}
