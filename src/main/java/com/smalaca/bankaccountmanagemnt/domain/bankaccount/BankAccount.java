package com.smalaca.bankaccountmanagemnt.domain.bankaccount;

import com.smalaca.bankaccountmanagemnt.domain.bankaccount.event.BankAccountCreated;

import java.util.UUID;

public class BankAccount {
    // aggregate id - technical identifier
    private UUID bankAccountId;
    private UUID ownerId;
    // account number - business identifier
    private UUID accountNumber;
    private int balance;

    public void listen(BankAccountCreated event) {
        bankAccountId = event.bankAccountId();
        ownerId = event.ownerId();
        accountNumber = event.accountNumber();
        balance = event.balance();
    }
}
