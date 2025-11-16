package io.backend.bank.transactions.infrastructure.adapter.repository;

import io.backend.bank.transactions.domain.model.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountJpaRepository extends JpaRepository<AccountEntity, String> {

}
