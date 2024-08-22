package org.example.jmschatroomgradle;

import org.springframework.jms.core.JmsTemplate;

import java.util.Map;

class Sender {
    private final String name;
    private final JmsTemplate jmsTemplate;

    Sender(String name, JmsTemplate jmsTemplate) {
        this.name = name;
        this.jmsTemplate = jmsTemplate;
        this.jmsTemplate.setPubSubDomain(true);  // Enable Pub/Sub mode
    }

    public void send(String message) {
        var announcement = Map.of(
                "name", name,
                "message", message
        );
        jmsTemplate.convertAndSend("pub-sub-announcements", announcement);
    }
}
