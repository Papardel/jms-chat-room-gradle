package org.example.jmschatroomgradle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ChatController {

    private final SenderFactory senderFactory;
    private final List<MessageRequest> messages = new ArrayList<>();
    private final Sender sender;

    @Autowired
    public ChatController(SenderFactory senderFactory, Sender sender) {
        this.senderFactory = senderFactory;
        this.sender = sender;
    }

    @PostMapping("/send")
    public void sendMessage(@RequestBody MessageRequest messageRequest) {
        sender.send(messageRequest.getMessage());
        messages.add(messageRequest);
    }

    @GetMapping("/messages")
    public List<MessageRequest> getMessages() {
        return messages;
    }

    public static class MessageRequest {
        private String name;
        private String message;

        // Getters and setters
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }
}