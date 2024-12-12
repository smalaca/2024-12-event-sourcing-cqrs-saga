package com.smalaca.transportpreparationsaga;

import com.smalaca.assortmentmanagementcommand.infrastructure.api.event.inmemory.assortment.ProductSoldPivotalEvent;
import org.springframework.stereotype.Component;

@Component
public class TransportPreparationSagaListener {
    private final TransportPreparationSagaRepository repository;

    TransportPreparationSagaListener(TransportPreparationSagaRepository repository) {
        this.repository = repository;
    }

    public void listen(ProductSoldPivotalEvent event) {
        TransportPreparationSaga saga = new TransportPreparationSaga(event.eventId().correlationId());

        if (saga.isCompleted()) {
            repository.delete(saga);
        } else {
            repository.save(saga);
        }
    }
}
