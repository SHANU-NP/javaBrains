package com.javaBrains.javaBrains.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.javaBrains.javaBrains.model.CoreKafKaMessage;
import com.javaBrains.javaBrains.model.Success;
import com.javaBrains.javaBrains.model.User;
import com.javaBrains.javaBrains.service.KafkaSenderService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class MessageController {

    @Value("${javabrain.constant.kafka.topic.notification}")
    private  String notificationTopic ;

    private final ObjectMapper objectMapper;
    private final KafkaSenderService kafkaSenderService;

    public MessageController(ObjectMapper objectMapper, KafkaSenderService kafkaSenderService) {
        this.objectMapper = objectMapper;
        this.kafkaSenderService = kafkaSenderService;
    }


    @PostMapping("/create/user")
    public Success createUser() throws JsonProcessingException {

        final User user = new User("shanu", "np", 12345);
        CoreKafKaMessage kafKaMessage = new CoreKafKaMessage();
        kafKaMessage.setUserCreateRequest(user);
        kafKaMessage.setType("createUserRequest");

        kafkaSenderService.sendMessage(objectMapper.writeValueAsString(kafKaMessage),"mytopic");
        return new Success("Success");
    }
}
