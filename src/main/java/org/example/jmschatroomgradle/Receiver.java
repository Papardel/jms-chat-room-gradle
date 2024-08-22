package org.example.jmschatroomgradle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class Receiver {

    @Autowired
    private MessageController messageController;

    @JmsListener(destination = "pub-sub-announcements")
    public void receiveMessage(Map<String, String> message) {
        messageController.addMessage(message);
        System.out.println("Received: " + message);
    }
}