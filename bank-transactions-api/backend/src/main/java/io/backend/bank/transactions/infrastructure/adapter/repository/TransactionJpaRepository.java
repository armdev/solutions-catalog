package io.backend.bank.transactions.infrastructure.adapter.repository;

import io.backend.bank.transactions.domain.model.TransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionJpaRepository extends JpaRepository<TransactionEntity, String> {

}
