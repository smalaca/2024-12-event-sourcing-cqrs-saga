package com.smalaca.bankaccountcommand.domain.bankaccount.event;

import com.smalaca.bankaccountcommand.domain.bankaccount.BankAccount;
import com.smalaca.sharedkernel.eventid.EventId;

import java.time.LocalDateTime;
import java.util.UUID;

public record NotEnoughMoneyRecognizedEvent(EventId eventId, UUID bankAccountId, int currentBalance, int withdrawal) implements BankAccountEvent {
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
