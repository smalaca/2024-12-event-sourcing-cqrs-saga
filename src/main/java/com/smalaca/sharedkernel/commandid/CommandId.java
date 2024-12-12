package com.smalaca.sharedkernel.commandid;

import com.smalaca.sharedkernel.eventid.EventId;

import java.time.LocalDateTime;
import java.util.UUID;

public record CommandId(UUID commandId, UUID traceId, UUID correlationId, LocalDateTime creationDateTime) {
    public static CommandId next(EventId eventId) {
        return new CommandId(createCommandId(), eventId.traceId(), eventId.correlationId(), createCreationDateTime());
    }

    private static LocalDateTime createCreationDateTime() {
        return LocalDateTime.now();
    }

    private static UUID createCommandId() {
        return UUID.randomUUID();
    }
}
