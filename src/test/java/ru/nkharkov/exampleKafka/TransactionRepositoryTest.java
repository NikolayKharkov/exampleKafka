package ru.nkharkov.exampleKafka;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ru.nkharkov.exampleKafka.repository.TransactionRepository;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;


@ExtendWith(SpringExtension.class)
@DataJpaTest
class TransactionRepositoryTest {

    @Autowired
    private TransactionRepository transactionRepository;

    @Test
    void testWhenCorrectBetweenTwoDates() {
        BigDecimal expected = new BigDecimal("100000");
        LocalDateTime start = LocalDateTime.parse("2023-05-16T15:00:00");
        LocalDateTime end = LocalDateTime.parse("2023-08-20T17:00:00");
        BigDecimal sum = transactionRepository.getTransactionsSumByDatesAndContractId(1, start, end).orElse(new BigDecimal(0));
        assertThat(sum).isEqualTo(expected);
    }

    @Test
    void testWhenCorrectBetweenOneDates() {
        BigDecimal expected = new BigDecimal("50000");
        LocalDateTime start = LocalDateTime.parse("2023-05-16T15:00:00");
        LocalDateTime end = LocalDateTime.parse("2023-07-20T17:00:00");
        BigDecimal sum = transactionRepository.getTransactionsSumByDatesAndContractId(1, start, end).orElse(new BigDecimal(0));
        assertThat(sum).isEqualTo(expected);
    }

    @Test
    void testWhenCorrectBetweenOneDatesButContractNotExist() {
        BigDecimal expected = new BigDecimal(0);
        LocalDateTime start = LocalDateTime.parse("2023-05-16T15:00:00");
        LocalDateTime end = LocalDateTime.parse("2023-07-20T17:00:00");
        BigDecimal sum = transactionRepository.getTransactionsSumByDatesAndContractId(3, start, end).orElse(expected);
        assertThat(sum).isEqualTo(expected);
    }

}
