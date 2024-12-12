package com.smalaca.bankaccountcommand.infrastructure.api.event.inmemory.bankaccount;

import com.smalaca.bankaccountcommand.domain.bankaccount.event.NotEnoughMoneyRecognizedEvent;
import com.smalaca.sharedkernel.eventid.EventId;

import java.util.UUID;

public record NotEnoughMoneyRecognizedPivotalEvent(EventId eventId, UUID bankAccountId, UUID ownerId, int currentBalance, int withdrawal) {
    static NotEnoughMoneyRecognizedPivotalEvent create(NotEnoughMoneyRecognizedEvent event, UUID ownerId) {
        return new NotEnoughMoneyRecognizedPivotalEvent(
                event.eventId().next(),
                event.bankAccountId(),
                ownerId,
                event.currentBalance(),
                event.withdrawal());
    }
}
