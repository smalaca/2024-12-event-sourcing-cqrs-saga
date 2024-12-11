package com.smalaca.bankaccountmanagemnt.domain.bankaccount;

import com.smalaca.bankaccountmanagemnt.domain.bankaccount.event.BankAccountEvent;
import com.smalaca.bankaccountmanagemnt.domain.eventid.EventId;

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
