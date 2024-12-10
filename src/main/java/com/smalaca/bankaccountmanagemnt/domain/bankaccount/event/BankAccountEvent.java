package com.smalaca.bankaccountmanagemnt.domain.bankaccount.event;

import com.smalaca.bankaccountmanagemnt.domain.bankaccount.BankAccount;

import java.time.LocalDateTime;
import java.util.UUID;

public interface BankAccountEvent {
    UUID bankAccountId();
    LocalDateTime creationDateTime();
    void visit(BankAccount bankAccount);
}
