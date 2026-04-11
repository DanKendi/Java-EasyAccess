package br.com.easyaccess.easyaccess.controller;

import br.com.easyaccess.easyaccess.client.dto.QueueInfoDTO;
import br.com.easyaccess.easyaccess.service.QueueMonitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/queues")
public class QueueMonitorController {

    @Autowired
    private QueueMonitorService queueMonitorService;

    @GetMapping("/reservas")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<QueueInfoDTO> getStatusFilaReservas() {
        return ResponseEntity.ok(queueMonitorService.getInfoFilaReservas());
    }
}
