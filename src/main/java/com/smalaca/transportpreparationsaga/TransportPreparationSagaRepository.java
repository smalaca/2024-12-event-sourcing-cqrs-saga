package com.smalaca.transportpreparationsaga;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Repository
public class TransportPreparationSagaRepository {
    private final Map<UUID, TransportPreparationSaga> sagas = new HashMap<>();

    void save(TransportPreparationSaga saga) {
        sagas.put(saga.getSagaId(), saga);
    }

    void delete(TransportPreparationSaga saga) {
        sagas.remove(saga.getSagaId());
    }
}
