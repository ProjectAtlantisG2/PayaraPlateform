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

    @Bean
    Queue queue() {
        return new Queue(metricsQueue, false);
    }
}
