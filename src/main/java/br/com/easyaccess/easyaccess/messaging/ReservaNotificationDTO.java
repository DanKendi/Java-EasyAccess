package br.com.easyaccess.easyaccess.messaging;

import java.util.Date;

public record ReservaNotificationDTO(
        Integer reservaId,
        String moradorNome,
        String areaComumNome,
        String status,
        Date data
) {
}
