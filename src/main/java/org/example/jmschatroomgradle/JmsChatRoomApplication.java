package org.example.jmschatroomgradle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JmsChatRoomApplication {

    static String clientId;

    public static void main(String[] args) {
        clientId = args.length > 0 ? args[0] : "default-client";
        SpringApplication.run(JmsChatRoomApplication.class, args);
    }

    @Bean
    public String getClientId() {
        return clientId;
    }

    @Bean
    public Sender initializeSender(SenderFactory senderFactory) {
        return senderFactory.createSender(clientId);
    }
}