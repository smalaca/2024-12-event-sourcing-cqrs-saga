package com.smalaca.bankaccountmanagemnt.infrastructure.api.event.inmemory.bankaccount;

import com.smalaca.bankaccountmanagemnt.domain.bankaccount.event.MoneyDepositedEvent;
import com.smalaca.bankaccountmanagemnt.domain.bankaccount.event.MoneyWithdrawnEvent;
import com.smalaca.bankaccountmanagemnt.domain.eventid.EventId;

import java.time.LocalDateTime;
import java.util.UUID;

public record TransactionMadeExternalEvent(EventId eventId, LocalDateTime publicationDateTime, UUID bankAccountId, int balance) {
    static TransactionMadeExternalEvent create(MoneyDepositedEvent event) {
        return new TransactionMadeExternalEvent(
                event.eventId().next(), event.creationDateTime(), event.bankAccountId(), event.balance());
    }

    static TransactionMadeExternalEvent create(MoneyWithdrawnEvent event) {
        return new TransactionMadeExternalEvent(
                event.eventId().next(), event.creationDateTime(), event.bankAccountId(), event.balance());
    }
}
