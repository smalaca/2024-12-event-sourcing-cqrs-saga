package com.smalaca.bankaccountmanagemnt.infrastructure.api.event.inmemory.bankaccount;

import com.smalaca.bankaccountmanagemnt.domain.bankaccount.event.BankAccountCreatedEvent;
import com.smalaca.bankaccountmanagemnt.domain.eventid.EventId;

import java.time.LocalDateTime;
import java.util.UUID;

public record BankAccountCreatedExternalEvent(
        EventId eventId, LocalDateTime publicationDateTime, UUID bankAccountId, UUID ownerId, String accountNumber, int balance) {
    static BankAccountCreatedExternalEvent create(BankAccountCreatedEvent event) {
        return new BankAccountCreatedExternalEvent(
                event.eventId().next(), event.creationDateTime(), event.bankAccountId(),
                event.ownerId(), event.accountNumber(), event.balance());
    }
}
