/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.project.acl.adapter.out.oracle;

import io.project.acl.domain.dto.CustomerDto;
import io.project.acl.domain.port.CustomerPort;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Optional;
import javax.sql.DataSource;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerOracleAdapter implements CustomerPort{

    private final DataSource dataSource;

    public CustomerOracleAdapter(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public Optional<CustomerDto> findCustomerById(Long customerId) {

        String sql = "{ call IBANK.get_customer_by_id(?, ?, ?, ?, ?) }";

        try (Connection connection = dataSource.getConnection(); CallableStatement cs = connection.prepareCall(sql)) {

            cs.setLong(1, customerId);

            cs.registerOutParameter(2, Types.VARCHAR);
            cs.registerOutParameter(3, Types.VARCHAR);
            cs.registerOutParameter(4, Types.VARCHAR);
            cs.registerOutParameter(5, Types.VARCHAR);

            cs.execute();

            String customer = cs.getString(2);
            String email = cs.getString(3);
            String nameE = cs.getString(4);
            String personNum = cs.getString(5);

            if (customer == null && email == null
                    && nameE == null && personNum == null) {
                return Optional.empty();
            }

            return Optional.of(
                    new CustomerDto(customerId, customer, email, nameE, personNum)
            );

        } catch (SQLException ex) {
           ex.printStackTrace();
        }
        return Optional.empty();
    }
}
