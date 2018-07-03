package org.exia.atlantis.config;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Azerom on 03/07/2018.
 */

@Configuration
@EnableRabbit
public class RabbitConfiguration {

    static final String metricTopicExchange = "MetricsExchange";

    static final String metricsQueue = "Metrics";

//    @Bean
//    public ConnectionFactory connectionFactory() {
//        return new CachingConnectionFactory("192.168.0.29");
//    }
//
//    @Bean
//    public AmqpAdmin amqpAdmin() {
//        return new RabbitAdmin(connectionFactory());
//    }
//
//    @Bean
//    public RabbitTemplate rabbitTemplate() {
//        return new RabbitTemplate(connectionFactory());
//    }

    @Bean
    Queue queue() {
        return new Queue(metricsQueue, false);
    }
}
