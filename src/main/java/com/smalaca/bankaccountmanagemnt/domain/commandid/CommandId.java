package com.smalaca.bankaccountmanagemnt.domain.commandid;

import java.time.LocalDateTime;
import java.util.UUID;

public record CommandId(UUID commandId, UUID traceId, UUID correlationId, LocalDateTime creationDateTime) {
}
