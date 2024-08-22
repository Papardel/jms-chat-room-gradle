package org.example.jmschatroomgradle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class SenderFactory {
    @Autowired
    private JmsTemplate jmsTemplate;

    Sender createSender(String name) {
        return new Sender(name, jmsTemplate);
    }
}
