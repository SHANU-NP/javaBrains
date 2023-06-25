package com.javaBrains.javaBrains.service;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class KafkaSenderService {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public KafkaSenderService(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    /**
     * to send kafka response
     *
     * @param message kafka send message
     * @param topic   kafka sender topic
     */
    @Async
    public void sendMessage(String message, String topic) {
        kafkaTemplate.send(topic, message);
    }

}
