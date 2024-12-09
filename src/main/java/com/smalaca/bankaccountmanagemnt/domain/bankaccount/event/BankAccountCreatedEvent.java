package com.smalaca.bankaccountmanagemnt.domain.bankaccount.event;

import com.smalaca.bankaccountmanagemnt.domain.bankaccount.BankAccount;
import com.smalaca.bankaccountmanagemnt.domain.eventid.EventId;

import java.time.LocalDateTime;
import java.util.UUID;

public record BankAccountCreatedEvent(EventId eventId, UUID bankAccountId, UUID ownerId, String accountNumber, int balance) implements BankAccountEvent {
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
