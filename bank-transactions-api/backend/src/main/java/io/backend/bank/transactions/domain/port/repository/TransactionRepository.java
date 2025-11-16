package io.backend.bank.transactions.domain.port.repository;

import io.backend.bank.transactions.domain.model.TransactionEntity;

import java.util.List;
import java.util.Optional;

public interface TransactionRepository {

    List<TransactionEntity> findAll();

    Optional<TransactionEntity> find(String reference);
}
