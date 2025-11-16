package io.backend.bank.transactions.infrastructure.adapter.repository;

import io.backend.bank.transactions.domain.model.TransactionEntity;
import io.backend.bank.transactions.domain.port.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class TransactionRepositoryImpl implements TransactionRepository {

    private final TransactionJpaRepository transactionJpaRepository;

    @Override
    public List<TransactionEntity> findAll() {

        log.info("All transactions will be got from DB");

        return transactionJpaRepository.findAll();
    }

    @Override
    public Optional<TransactionEntity> find(String reference) {

        log.info("Transaction with reference {} will be got from DB", reference);

        return transactionJpaRepository.findById(reference);

    }
}
