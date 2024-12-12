package com.smalaca.bankaccountcommand.domain.bankaccount;

import com.smalaca.bankaccountcommand.domain.bankaccount.command.DepositMoneyCommand;
import com.smalaca.bankaccountcommand.domain.bankaccount.command.WithdrawMoneyCommand;
import com.smalaca.bankaccountcommand.domain.bankaccount.event.BankAccountOpenedEvent;
import com.smalaca.bankaccountcommand.domain.bankaccount.event.BankAccountEvent;
import com.smalaca.bankaccountcommand.domain.bankaccount.event.MoneyDepositedEvent;
import com.smalaca.bankaccountcommand.domain.bankaccount.event.MoneyWithdrawnEvent;
import com.smalaca.bankaccountcommand.domain.bankaccount.event.NotEnoughMoneyRecognizedEvent;
import com.smalaca.bankaccountcommand.domain.eventid.EventId;

import java.util.UUID;

public class BankAccount {
    // aggregate id - technical identifier
    private UUID bankAccountId;
    private UUID ownerId;
    // account number - business identifier
    private String accountNumber;
    private int balance;

    public void listen(BankAccountOpenedEvent event) {
        bankAccountId = event.bankAccountId();
        ownerId = event.ownerId();
        accountNumber = event.accountNumber();
        balance = event.balance();
    }

    public void listen(MoneyDepositedEvent event) {
        balance += event.deposit();
    }

    public MoneyDepositedEvent deposit(DepositMoneyCommand command) {
        MoneyDepositedEvent event = new MoneyDepositedEvent(
                EventId.nextAfter(command.commandId()),
                bankAccountId,
                balance + command.deposit(),
                command.deposit(),
                balance
        );
        listen(event);
        return event;
    }

    public BankAccountEvent withdraw(WithdrawMoneyCommand command) {
        if(balance > command.withdrawal()) {
            MoneyWithdrawnEvent event = new MoneyWithdrawnEvent(
                    EventId.nextAfter(command.commandId()),
                    bankAccountId,
                    balance - command.withdrawal(),
                    command.withdrawal(),
                    balance);
            listen(event);
            return event;
        } else {
            NotEnoughMoneyRecognizedEvent event = new NotEnoughMoneyRecognizedEvent(
                    EventId.nextAfter(command.commandId()),
                    bankAccountId,
                    balance,
                    command.withdrawal());
            listen(event);
            return event;
        }
    }

    public void listen(NotEnoughMoneyRecognizedEvent event) {
        // nothing to be done
    }

    public void listen(MoneyWithdrawnEvent event) {
        balance -= event.withdrawal();
    }

    public BankAccountDto asDto() {
        return new BankAccountDto(bankAccountId, ownerId);
    }
}
