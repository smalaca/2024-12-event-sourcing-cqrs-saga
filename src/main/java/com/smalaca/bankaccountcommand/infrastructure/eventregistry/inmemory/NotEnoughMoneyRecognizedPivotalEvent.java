package com.smalaca.bankaccountcommand.infrastructure.eventregistry.inmemory;

import com.smalaca.bankaccountcommand.domain.bankaccount.event.NotEnoughMoneyRecognizedEvent;
import com.smalaca.bankaccountcommand.domain.eventid.EventId;

import java.util.UUID;

public record NotEnoughMoneyRecognizedPivotalEvent(EventId eventId, UUID bankAccountId, UUID ownerId, int currentBalance, int withdrawal) {
    private static final UUID FAKE_OWNER_ID = UUID.randomUUID();

    static NotEnoughMoneyRecognizedPivotalEvent create(NotEnoughMoneyRecognizedEvent event) {
        return new NotEnoughMoneyRecognizedPivotalEvent(
                event.eventId().next(),
                event.bankAccountId(),
                FAKE_OWNER_ID,
                event.currentBalance(),
                event.withdrawal());
    }
}
