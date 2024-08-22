package org.example.jmschatroomgradle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class ChatController {

    @Autowired
    private JmsTemplate jmsTemplate;

    @PostMapping("/sendMessage")
    public void sendMessage(@RequestBody Map<String, String> message) {
        jmsTemplate.convertAndSend("pub-sub-announcements", message);
    }
}