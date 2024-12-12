package com.smalaca.accountdebtsaga;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Repository
public class AccountDebtSagaRepository {
    private final Map<UUID, AccountDebtSaga> sagas = new HashMap<>();

    void save(AccountDebtSaga saga) {
        sagas.put(saga.getSagaId(), saga);
    }

    void delete(AccountDebtSaga saga) {

    }
}
