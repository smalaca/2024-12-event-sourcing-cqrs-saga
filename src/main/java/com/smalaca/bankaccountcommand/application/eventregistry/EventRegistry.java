package com.smalaca.bankaccountcommand.application.eventregistry;

import com.smalaca.bankaccountcommand.domain.bankaccount.event.BankAccountEvent;

public interface EventRegistry {
    void publish(BankAccountEvent event);
}
