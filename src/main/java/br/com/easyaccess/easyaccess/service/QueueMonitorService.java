package br.com.easyaccess.easyaccess.service;

import br.com.easyaccess.easyaccess.client.CloudAmqpClient;
import br.com.easyaccess.easyaccess.client.dto.QueueInfoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Base64;

@Service
public class QueueMonitorService {

    @Autowired
    private CloudAmqpClient cloudAmqpClient;

    @Value("${cloudamqp.api.url}")
    private String apiUrl;

    @Value("${RABBITMQ_USERNAME}")
    private String username;

    @Value("${RABBITMQ_PASSWORD}")
    private String password;

    @Value("${RABBITMQ_VHOST}")
    private String vhost;

    public QueueInfoDTO getInfoFilaReservas() {
        String credentials = username + ":" + password;
        String basicAuth = "Basic " + Base64.getEncoder()
                .encodeToString(credentials.getBytes());

        return cloudAmqpClient.getQueueInfo(vhost, "reservas.notificacoes", basicAuth);
    }
}
