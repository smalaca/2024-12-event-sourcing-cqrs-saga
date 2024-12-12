package com.smalaca.bankaccountcommand.domain.eventid;

import com.smalaca.bankaccountcommand.domain.commandid.CommandId;

import java.time.LocalDateTime;
import java.util.UUID;

public record EventId(UUID eventId, UUID traceId, UUID correlationId, LocalDateTime creationDateTime) {
    public static EventId nextAfter(CommandId commandId) {
        return new EventId(createEventId(), commandId.traceId(), commandId.correlationId(), createCreationDateTime());
    }

    public EventId next() {
        return new EventId(createEventId(), traceId(), correlationId(), createCreationDateTime());
    }

    private static LocalDateTime createCreationDateTime() {
        return LocalDateTime.now();
    }

    private static UUID createEventId() {
        return UUID.randomUUID();
    }
}
