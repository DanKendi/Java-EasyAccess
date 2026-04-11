package br.com.easyaccess.easyaccess.client.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record QueueInfoDTO(

    String name,
    Integer messages,
    Integer consumers,
    @JsonProperty("messages_ready") Integer messagesReady,
    @JsonProperty("messages_unacknowledged") Integer messagesUnacknowledged
) {
}
