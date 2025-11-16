package io.backend.bank.transactions.domain.port.repository;

import io.backend.bank.transactions.domain.model.AccountEntity;

import java.util.Optional;

public interface AccountRepository {

    void save(AccountEntity accountEntity);

    Optional<AccountEntity> find(String accountIban);

}
