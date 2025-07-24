package com.training.producer;

import com.training.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@Service
public class KafkaAvroProducer {

    @Autowired
    private KafkaTemplate<String, Employee> template;

    @Value("$(topic.name)")
    private String topicName;

    public void send(Employee employee) {
        CompletableFuture<SendResult<String, Employee>> send = template.send("kafka-avro-topic", UUID.randomUUID().toString(), employee);
        send.whenComplete((result, ex) -> {
            if (ex == null) {
                System.out.println("Sent Message=[" + employee + "]" +
                        " with Offset = [" + result.getRecordMetadata().offset() + "]" +
                        " to Partition = [" + result.getRecordMetadata().partition() + "]");
            } else {
                System.out.println("Unable to send message={" + employee + "]" +
                        "due to error : " + ex.getMessage());
            }
        });
    }
}
