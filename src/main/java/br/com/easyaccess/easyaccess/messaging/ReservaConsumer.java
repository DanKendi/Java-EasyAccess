package br.com.easyaccess.easyaccess.messaging;

import br.com.easyaccess.easyaccess.config.RabbitMQConfig;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

public class ReservaConsumer {

    @RabbitListener(queues = RabbitMQConfig.QUEUE_RESERVAS)
    public void consumirNotificacao(ReservaNotificationDTO dto){
        System.out.println("Reserva recebida: " + dto.reservaId() + " - Morador: " + dto.moradorNome() + " - Status: " + dto.status());
    }
}
