package com.smalaca.bankaccountcommand.infrastructure.eventregistry.inmemory;

import com.smalaca.accountdebtsaga.AccountDebtSagaListener;
import com.smalaca.bankaccountcommand.domain.bankaccount.event.NotEnoughMoneyRecognizedEvent;
import org.springframework.stereotype.Component;

@Component
class BankAccountPivotalEventPublisher {
    private final AccountDebtSagaListener listener;

    BankAccountPivotalEventPublisher(AccountDebtSagaListener listener) {
        this.listener = listener;
    }

    void listen(NotEnoughMoneyRecognizedEvent event) {
        NotEnoughMoneyRecognizedPivotalEvent pivotalEvent = NotEnoughMoneyRecognizedPivotalEvent.create(event);
        listener.listen(pivotalEvent);
    }
}
