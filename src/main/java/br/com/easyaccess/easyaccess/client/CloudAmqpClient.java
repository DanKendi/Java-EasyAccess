package br.com.easyaccess.easyaccess.client;


import br.com.easyaccess.easyaccess.client.dto.QueueInfoDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "cloudamqp", url = "${cloudamqp.api.url}")
public interface CloudAmqpClient {

    @GetMapping("/api/queues/{vhost}/{queue}")
    QueueInfoDTO getQueueInfo(
            @PathVariable("vhost") String vhost,
            @PathVariable("queue") String queue,
            @RequestHeader("Authorization") String authorization
    );

}
