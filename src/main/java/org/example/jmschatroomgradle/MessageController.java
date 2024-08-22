package org.example.jmschatroomgradle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class MessageController {

    @Autowired
    private JmsTemplate jmsTemplate;

    private List<Map<String, String>> messages = new ArrayList<>();

    @PostMapping("/send")
    public void sendMessage(@RequestBody Map<String, String> message) {
        jmsTemplate.convertAndSend("pub-sub-announcements", message);
    }

    @GetMapping("/messages")
    public List<Map<String, String>> getMessages() {
        return messages;
    }

    public void addMessage(Map<String, String> message) {
        messages.add(message);
    }
}