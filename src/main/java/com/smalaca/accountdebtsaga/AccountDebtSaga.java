package com.smalaca.accountdebtsaga;

import com.smalaca.bankaccountcommand.infrastructure.eventregistry.inmemory.NotEnoughMoneyRecognizedPivotalEvent;

import java.util.UUID;

public class AccountDebtSaga {
    private UUID sagaId;

    AccountDebtSaga(UUID sagaId) {
        this.sagaId = sagaId;
    }

    UUID getSagaId() {
        return sagaId;
    }

    void listen(NotEnoughMoneyRecognizedPivotalEvent event) {

    }

    boolean isCompleted() {
        return false;
    }
}
