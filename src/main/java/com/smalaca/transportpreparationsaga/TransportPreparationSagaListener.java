package com.smalaca.transportpreparationsaga;

import com.smalaca.assortmentmanagementcommand.infrastructure.api.event.inmemory.assortment.ProductSoldPivotalEvent;
import com.smalaca.transportservice.TransportOrderedPivotalEvent;
import com.smalaca.warehouseservice.PackagePreparedPivotalEvent;
import org.springframework.stereotype.Component;

@Component
public class TransportPreparationSagaListener {
    private final TransportPreparationSagaRepository repository;
    private final TransportServiceClient transportServiceClient;
    private final WarehouseServiceClient warehouseServiceClient;

    TransportPreparationSagaListener(TransportPreparationSagaRepository repository, TransportServiceClient transportServiceClient, WarehouseServiceClient warehouseServiceClient) {
        this.repository = repository;
        this.transportServiceClient = transportServiceClient;
        this.warehouseServiceClient = warehouseServiceClient;
    }

    public void listen(ProductSoldPivotalEvent event) {
        TransportPreparationSaga saga = new TransportPreparationSaga(event.eventId().correlationId());

        saga.listen(event, transportServiceClient, warehouseServiceClient);

        save(saga);
    }

    public void listen(TransportOrderedPivotalEvent event) {
        TransportPreparationSaga saga = repository.findById(event.sagaId());

        saga.listen(event);

        save(saga);
    }

    public void listen(PackagePreparedPivotalEvent event) {
        TransportPreparationSaga saga = repository.findById(event.sagaId());

        saga.listen(event);

        save(saga);
    }

    private void save(TransportPreparationSaga saga) {
        if (saga.isCompleted()) {
            repository.delete(saga);
        } else {
            repository.save(saga);
        }
    }
}
