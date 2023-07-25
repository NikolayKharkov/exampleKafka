package ru.nkharkov.exampleKafka.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import ru.nkharkov.exampleKafka.dto.ContractEvent;
import ru.nkharkov.exampleKafka.dto.SumDto;
import ru.nkharkov.exampleKafka.producer.SumProducer;
import ru.nkharkov.exampleKafka.repository.TransactionRepository;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
@Slf4j
public class ContractConsumer {

    private SumProducer sumProducer;

    private TransactionRepository transactionRepository;

    public ContractConsumer(SumProducer sumProducer, TransactionRepository transactionRepository) {
        this.sumProducer = sumProducer;
        this.transactionRepository = transactionRepository;
    }

    @KafkaListener(topics = "${spring.kafka.topik.consumer.name}", groupId = "${spring.kafka.consumer.group-id}")
    public void consume(ContractEvent contractEvent) {
        log.info(String.format("Get message: ", contractEvent));

        int contractNumber = contractEvent.getContractDto().getNumber();
        LocalDateTime start = contractEvent.getStart();
        LocalDateTime end = contractEvent.getEnd();

        BigDecimal sum = transactionRepository.getTransactionsSumByDatesAndContractId(contractNumber, start, end).orElse(BigDecimal.ZERO);
        SumDto sumMessage = new SumDto(sum);

        log.info(String.format("Send message: ", sumMessage));
        sumProducer.sendMessage(sumMessage);
    }
}
