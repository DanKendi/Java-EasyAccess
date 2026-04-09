package br.com.easyaccess.easyaccess.messaging;


import br.com.easyaccess.easyaccess.config.RabbitMQConfig;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ReservaProducer {

    @Autowired
    private AmqpTemplate amqpTemplate;

    public void notificarReservaCriada(ReservaNotificationDTO dto){
        amqpTemplate.convertAndSend(RabbitMQConfig.EXCHANGE_RESERVAS, RabbitMQConfig.ROUTING_KEY, dto);
        System.out.println("Mensagem enviada" + dto);
    }
}
