package org.example.jmschatroomgradle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
import java.util.Map;

/**
 * Component responsible for receiving messages from the JMS destination.
 */
@Component
public class Receiver {

    @Autowired
    private MessageController messageController;

    /**
     * Method to receive messages from the "pub-sub-announcements" destination.
     * Adds the received message to the MessageController's message list and prints it to the terminal.
     *
     * @param message The received message as a map of key-value pairs
     */
    @JmsListener(destination = "pub-sub-announcements")
    public void receiveMessage(Map<String, String> message) {
        messageController.addMessage(message);
        System.out.println("Received: " + message);
    }
}