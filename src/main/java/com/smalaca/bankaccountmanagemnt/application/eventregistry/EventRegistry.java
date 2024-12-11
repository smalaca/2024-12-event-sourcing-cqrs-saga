package com.smalaca.bankaccountmanagemnt.application.eventregistry;

import com.smalaca.bankaccountmanagemnt.domain.bankaccount.event.BankAccountEvent;

public interface EventRegistry {
    void publish(BankAccountEvent event);
}
