package io.project.acl.adapter.out.oracle;

import io.project.acl.domain.model.BalanceResult;
import io.project.acl.domain.port.AccountPort;
import java.math.BigDecimal;
import org.springframework.stereotype.Component;

@Component
public class AccountProcedureAdapter implements AccountPort {

    @Override
    public BalanceResult getBalance(String accountId) {

        // Simulating Oracle procedure call
        return new BalanceResult(
                new BigDecimal("1000.00"),
                "USD"
        );
    }
}
