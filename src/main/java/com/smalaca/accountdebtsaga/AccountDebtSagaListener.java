package com.smalaca.accountdebtsaga;

import com.smalaca.bankaccountcommand.infrastructure.api.event.inmemory.bankaccount.NotEnoughMoneyRecognizedPivotalEvent;
import com.smalaca.bankaccounthistoryservice.BankAccountHistoryNotFoundEvent;
import com.smalaca.bikgatewayservice.BikReportNotFoundEvent;
import org.springframework.stereotype.Component;

@Component
public class AccountDebtSagaListener {
    private final AccountDebtSagaRepository repository;
    private final BikClient bikClient;
    private final BankAccountHistoryClient bankAccountHistoryClient;

    AccountDebtSagaListener(
            AccountDebtSagaRepository repository, BikClient bikClient, BankAccountHistoryClient bankAccountHistoryClient) {
        this.repository = repository;
        this.bikClient = bikClient;
        this.bankAccountHistoryClient = bankAccountHistoryClient;
    }

    public void listen(NotEnoughMoneyRecognizedPivotalEvent event) {
        AccountDebtSaga saga = new AccountDebtSaga(event.eventId().correlationId());

        saga.listen(event, bikClient, bankAccountHistoryClient);

        complete(saga);
    }

    public void listen(BikReportNotFoundEvent event) {
        AccountDebtSaga saga = repository.findById(event.accountDebtSagaId());

        saga.listen(event);

        complete(saga);
    }

    public void listen(BankAccountHistoryNotFoundEvent event) {
        AccountDebtSaga saga = repository.findById(event.accountDebtSagaId());

        saga.listen(event);

        complete(saga);
    }

    private void complete(AccountDebtSaga saga) {
        if (saga.isCompleted()) {
            repository.delete(saga);
        } else {
            repository.save(saga);
        }
    }
}
