package com.smalaca.bankaccountmanagemnt.application.eventregistry;

import com.smalaca.bankaccountmanagemnt.domain.bankaccount.event.BankAccountCreated;

public interface EventRegistry {
    void publish(BankAccountCreated event);
}
