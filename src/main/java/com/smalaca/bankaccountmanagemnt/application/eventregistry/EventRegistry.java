package com.smalaca.bankaccountmanagemnt.application.eventregistry;

import com.smalaca.bankaccountmanagemnt.domain.bankaccount.event.BankAccountCreated;
import com.smalaca.bankaccountmanagemnt.domain.bankaccount.event.MoneyDeposited;

public interface EventRegistry {
    void publish(BankAccountCreated event);

    void publish(MoneyDeposited event);
}
