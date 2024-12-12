package com.smalaca.accountdebtsaga;

import com.smalaca.bankaccountcommand.infrastructure.api.event.inmemory.bankaccount.NotEnoughMoneyRecognizedPivotalEvent;
import org.springframework.stereotype.Component;

@Component
public class AccountDebtSagaListener {
    private final AccountDebtSagaRepository repository;

    public AccountDebtSagaListener(AccountDebtSagaRepository repository) {
        this.repository = repository;
    }

    public void listen(NotEnoughMoneyRecognizedPivotalEvent event) {
        AccountDebtSaga saga = new AccountDebtSaga(event.eventId().correlationId());

        saga.listen(event);

        if (saga.isCompleted()) {
            repository.delete(saga);
        } else {
            repository.save(saga);
        }
    }
}
