package com.smalaca.bankaccounthistoryservice;

import com.smalaca.sharedkernel.eventid.EventId;

import java.util.UUID;

public record BankAccountHistoryNotFoundEvent(EventId eventId, UUID accountDebtSagaId, UUID bankAccountId, UUID ownerId) {
}
