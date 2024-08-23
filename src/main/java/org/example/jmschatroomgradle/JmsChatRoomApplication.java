package org.example.jmschatroomgradle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * Main class for the JMS Chat Room Spring Boot application.
 */
@SpringBootApplication
public class JmsChatRoomApplication {

    // Static variable to hold the client ID
    static String clientId;

    /**
     * Main method to run the Spring Boot application.
     * Reads the client ID from the environment variable and starts the application.
     *
     * @param args Command line arguments
     */
    public static void main(String[] args) {
        clientId = System.getenv("CLIENT_ID");
        if (clientId == null || clientId.isEmpty()) {
            throw new IllegalArgumentException("CLIENT_ID environment variable is not set");
        }
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