package com.smalaca.bankaccountcommand.domain.bankaccount.event;

import com.smalaca.bankaccountcommand.domain.bankaccount.BankAccount;
import com.smalaca.bankaccountcommand.domain.eventid.EventId;

import java.time.LocalDateTime;
import java.util.UUID;

public record BankAccountOpenedEvent(EventId eventId, UUID bankAccountId, UUID ownerId, String accountNumber, int balance) implements BankAccountEvent {
    @Override
    public LocalDateTime creationDateTime() {
        return eventId.creationDateTime();
    }

    @Override
    public void visit(BankAccount bankAccount) {
        System.out.println(getClass().getName());
        bankAccount.listen(this);
    }
}
