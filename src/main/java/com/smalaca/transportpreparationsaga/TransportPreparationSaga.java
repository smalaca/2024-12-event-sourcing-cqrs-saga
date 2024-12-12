package com.smalaca.transportpreparationsaga;

import java.util.UUID;

class TransportPreparationSaga {
    private final UUID sagaId;

    TransportPreparationSaga(UUID sagaId) {
        this.sagaId = sagaId;
    }

    UUID getSagaId() {
        return sagaId;
    }

    boolean isCompleted() {
        return false;
    }
}
