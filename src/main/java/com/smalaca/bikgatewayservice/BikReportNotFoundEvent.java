package com.smalaca.bikgatewayservice;

import com.smalaca.sharedkernel.eventid.EventId;

import java.util.UUID;

public record BikReportNotFoundEvent(EventId eventId, UUID accountDebtSagaId, UUID bankAccountId, UUID ownerId) {
}
