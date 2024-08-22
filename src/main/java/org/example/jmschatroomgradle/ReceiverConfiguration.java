package org.example.jmschatroomgradle;

import org.springframework.boot.autoconfigure.jms.DefaultJmsListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.connection.SingleConnectionFactory;
import org.springframework.jms.annotation.EnableJms;

@Configuration
@EnableJms
class ReceiverConfiguration {

    @Bean
    DefaultJmsListenerContainerFactory jmsListenerContainerFactory(SingleConnectionFactory connectionFactory,
                                                                   DefaultJmsListenerContainerFactoryConfigurer configurer, String clientId) {
        connectionFactory.setClientId(clientId);
        var factory = new DefaultJmsListenerContainerFactory();
        factory.setPubSubDomain(true);  // Ensure this factory is configured for Pub/Sub
        configurer.configure(factory, connectionFactory);
        return factory;
    }
}
