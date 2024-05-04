package com.monitor.app;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/message")
public class HomeController {

    @GetMapping("/greet")
    public Map<String,String> greetMessage(){
        Map<String,String> messageMap =  new HashMap<>();
        messageMap.put("Greeting", "Hello");
        return messageMap;
    }
}
