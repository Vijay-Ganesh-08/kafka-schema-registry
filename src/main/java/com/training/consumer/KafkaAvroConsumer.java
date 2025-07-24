package com.training.consumer;

import com.training.model.Employee;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaAvroConsumer {

    @KafkaListener(topics = "kafka-avro-topic")
    public void listenMessages(ConsumerRecord<String, Employee> consumerRecord) {
        String key = consumerRecord.key();
        Employee value = consumerRecord.value();

        log.info("Avro message received for key : {} value {}", key, value.toString());
    }
}
