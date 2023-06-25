package com.javaBrains.javaBrains.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.javaBrains.javaBrains.config.JavaBrainsProperties;
import com.javaBrains.javaBrains.model.CoreKafKaMessage;
import com.javaBrains.javaBrains.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
@Slf4j
@Service
public class KafkaListenerService {

    private final JavaBrainsProperties javaBrainsProperties;
    private final ObjectMapper objectMapper;

    public KafkaListenerService(JavaBrainsProperties javaBrainsProperties, ObjectMapper objectMapper) {
        this.javaBrainsProperties = javaBrainsProperties;
        this.objectMapper = objectMapper;
    }


    @KafkaListener(topics = "${java-brains.properties.kafka-topic-notification}")
    public void notificationListener(String message) throws JsonProcessingException {
        CoreKafKaMessage coreKafKaMessage = objectMapper.readValue(message, new TypeReference<CoreKafKaMessage>() {});

        switch (coreKafKaMessage.getType()){
            case "createUserRequest":
                User user = coreKafKaMessage.getUserCreateRequest();
                log.info("<--------------- kafka message received : first name {} last name : {} phone : {} ------------>",user.getFirstName(),user.getLastName(),user.getPhone());
                break;
            default:
                log.info("<--------------- invalid response ----------------->");
                break;
        }
    }
}
