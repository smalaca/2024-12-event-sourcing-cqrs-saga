package com.smalaca.bankaccountcommand.infrastructure.api.event.inmemory.bankaccount;

import com.smalaca.bankaccountcommand.domain.bankaccount.event.BankAccountOpenedEvent;
import com.smalaca.sharedkernel.eventid.EventId;

import java.time.LocalDateTime;
import java.util.UUID;

public record BankAccountOpenedExternalEvent(
        EventId eventId, LocalDateTime publicationDateTime, UUID bankAccountId, UUID ownerId, String accountNumber, int balance) {
    static BankAccountOpenedExternalEvent create(BankAccountOpenedEvent event) {
        return new BankAccountOpenedExternalEvent(
                event.eventId().next(), event.creationDateTime(), event.bankAccountId(),
                event.ownerId(), event.accountNumber(), event.balance());
    }
}
