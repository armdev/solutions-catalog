package io.backend.bank.transactions.application.use_case;

import io.backend.bank.transactions.application.command.NewAccountCommand;
import io.backend.bank.transactions.domain.exception.AccountAlreadyExistsException;
import io.backend.bank.transactions.domain.model.AccountEntity;
import io.backend.bank.transactions.domain.port.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Slf4j
@Service
@RequiredArgsConstructor
public class CreateAccountUseCase {

    private final AccountRepository accountRepository;

    @Transactional
    public void create(NewAccountCommand newAccountCommand) {

        log.info("Process in CreateAccountUseCase starts");

        AccountEntity accountEntity = AccountEntity.of(newAccountCommand);

        processNewAccount(accountEntity);

        log.info("Process in CreateTransactionUseCase ends");
    }

    private void processNewAccount(AccountEntity accountEntity) {

        AccountEntity accountStored = accountRepository.find(accountEntity.getId()).orElse(null);

        if (Objects.isNull(accountStored)) {
            accountRepository.save(accountEntity);
        } else {
            log.error("Account with IBAN {} already exists in the system", accountEntity.getId());
            throw new AccountAlreadyExistsException(accountEntity.getId());
        }

    }
}
