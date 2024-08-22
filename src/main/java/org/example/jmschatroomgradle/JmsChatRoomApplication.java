package org.example.jmschatroomgradle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.UUID;

/**
 * Main class for the JMS Chat Room Spring Boot application.
 */
@SpringBootApplication
public class JmsChatRoomApplication {

    // Static variable to hold the client ID
    static String clientId;

    /**
     * Main method to run the Spring Boot application.
     * Generates a unique client ID and starts the application.
     *
     * @param args Command line arguments
     */
    public static void main(String[] args) {
        clientId = UUID.randomUUID().toString();
        SpringApplication.run(JmsChatRoomApplication.class, args);
    }

    /**
     * Bean to provide the client ID.
     *
     * @return The unique client ID
     */
    @Bean
    public String getClientId() {
        return clientId;
    }
}