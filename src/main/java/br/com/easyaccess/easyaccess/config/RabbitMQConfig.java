package br.com.easyaccess.easyaccess.config;


import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.connection.RabbitConnectionFactoryBean;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    public static final String QUEUE_RESERVAS = "reservas.notificacoes";
    public static final String EXCHANGE_RESERVAS = "reservas.exchange";
    public static final String ROUTING_KEY = "reservas.criada";

    @Bean
    public Queue queueReservas(){
        return QueueBuilder.durable(QUEUE_RESERVAS).build();
    }

    @Bean
    public DirectExchange exchangeReservas(){
        return new DirectExchange(EXCHANGE_RESERVAS);
    }

    @Bean
    public Binding bindingReservas(Queue queueReservas, DirectExchange exchangeReservas){
        return BindingBuilder.bind(queueReservas)
                .to(exchangeReservas)
                .with(ROUTING_KEY);
    }

    @Bean
    public MessageConverter messageConverter(){
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public AmqpTemplate amqpTemplate(ConnectionFactory connectionFactory){
        RabbitTemplate template = new RabbitTemplate(connectionFactory);
        template.setMessageConverter(messageConverter());
        return template;
    }

    @Bean
    public ApplicationRunner rabbitConnectionTest(ConnectionFactory connectionFactory) {
        return args -> {
            try {
                connectionFactory.createConnection().close();
                System.out.println("Conectado ao CloudAMQP com sucesso!");
            } catch (Exception e) {
                System.out.println("Falha ao conectar no CloudAMQP: " + e.getMessage());
            }
        };
    }

}
