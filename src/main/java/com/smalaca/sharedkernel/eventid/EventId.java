package com.smalaca.sharedkernel.eventid;

import com.smalaca.sharedkernel.commandid.CommandId;

import java.time.LocalDateTime;
import java.util.UUID;

public record EventId(UUID eventId, UUID traceId, UUID correlationId, LocalDateTime creationDateTime) {
    public static EventId next(CommandId commandId) {
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
