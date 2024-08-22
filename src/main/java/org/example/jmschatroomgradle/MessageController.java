package org.example.jmschatroomgradle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * REST controller for handling message-related operations.
 */
@RestController
public class MessageController {

    @Autowired
    private JmsTemplate jmsTemplate;

    // List to store messages
    private final List<Map<String, String>> messages = new ArrayList<>();

    /**
     * Endpoint to send a message.
     * The message is sent to the "pub-sub-announcements" destination.
     *
     * @param message The message to be sent, provided in the request body
     */
    @PostMapping("/send")
    public void sendMessage(@RequestBody Map<String, String> message) {
        jmsTemplate.convertAndSend("pub-sub-announcements", message);
    }

    /**
     * Endpoint to retrieve all messages.
     *
     * @return A list of all messages
     */
    @GetMapping("/messages")
    public List<Map<String, String>> getMessages() {
        return messages;
    }

    /**
     * Adds a message to the list of messages.
     *
     * @param message The message to be added
     */
    public void addMessage(Map<String, String> message) {
        messages.add(message);
    }
}