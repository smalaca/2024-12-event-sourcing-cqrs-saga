package com.smalaca.bankaccountmanagemnt.domain.bankaccount.event;

import com.smalaca.bankaccountmanagemnt.domain.bankaccount.BankAccount;
import com.smalaca.bankaccountmanagemnt.domain.eventid.EventId;

import java.time.LocalDateTime;
import java.util.UUID;

public record MoneyDeposited(EventId eventId, UUID bankAccountId, int balance, int deposit, int previousBalance) implements BankAccountEvent {
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
