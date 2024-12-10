package com.smalaca.bankaccountmanagemnt.domain.bankaccount;

import com.smalaca.bankaccountmanagemnt.domain.bankaccount.command.DepositMoneyCommand;
import com.smalaca.bankaccountmanagemnt.domain.bankaccount.event.BankAccountCreated;
import com.smalaca.bankaccountmanagemnt.domain.bankaccount.event.MoneyDeposited;
import com.smalaca.bankaccountmanagemnt.domain.eventid.EventId;

import java.util.UUID;

public class BankAccount {
    // aggregate id - technical identifier
    private UUID bankAccountId;
    private UUID ownerId;
    // account number - business identifier
    private String accountNumber;
    private int balance;

    public void listen(BankAccountCreated event) {
        bankAccountId = event.bankAccountId();
        ownerId = event.ownerId();
        accountNumber = event.accountNumber();
        balance = event.balance();
    }

    public void listen(MoneyDeposited event) {
        balance += event.deposit();
    }

    public MoneyDeposited deposit(DepositMoneyCommand command) {
        MoneyDeposited event = new MoneyDeposited(
                EventId.nextAfter(command.commandId()),
                bankAccountId,
                balance + command.deposit(),
                command.deposit(),
                balance
        );
        listen(event);
        return event;
    }
}
