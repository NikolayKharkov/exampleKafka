package ru.nkharkov.exampleKafka.producer;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import ru.nkharkov.exampleKafka.dto.SumDto;

@Service
@Slf4j
public class SumProducer {

    private final NewTopic topic;

    private KafkaTemplate<String, SumDto> kafkaTemplate;

    public SumProducer(NewTopic topic, KafkaTemplate<String, SumDto> kafkaTemplate) {
        this.topic = topic;
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(SumDto sumDto) {
        Message<SumDto> message = MessageBuilder
                .withPayload(sumDto)
                .setHeader(KafkaHeaders.TOPIC, topic.name())
                .build();
        log.info(String.format("Create message: %s ", message));
        kafkaTemplate.send(message);
    }

}
