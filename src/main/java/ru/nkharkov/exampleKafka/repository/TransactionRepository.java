package ru.nkharkov.exampleKafka.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.nkharkov.exampleKafka.models.Transaction;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer> {

    @Query(value = "select sum(t.sum) from Transaction t where t.contract.contractId = :contract_id and t.transactionDateTime between :start_date and :end_date")
    Optional<BigDecimal> getTransactionsSumByDatesAndContractId(@Param("contract_id") int contract_id, @Param("start_date") LocalDateTime startDate, @Param("end_date") LocalDateTime endDate);

}
