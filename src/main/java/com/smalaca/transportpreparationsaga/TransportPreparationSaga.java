package com.smalaca.transportpreparationsaga;

import com.smalaca.assortmentmanagementcommand.infrastructure.api.event.inmemory.assortment.ProductSoldPivotalEvent;
import com.smalaca.sharedkernel.commandid.CommandId;
import com.smalaca.transportservice.OrderTransportCommand;
import com.smalaca.transportservice.TransportOrderedPivotalEvent;
import com.smalaca.warehouseservice.PackagePreparedPivotalEvent;
import com.smalaca.warehouseservice.PreparePackageCommand;

import java.util.UUID;

class TransportPreparationSaga {
    private final UUID sagaId;
    private UUID assortmentId;
    private UUID productId;
    private int quantity;
    private Boolean packagePreparationRequested;
    private Boolean packagePrepared;
    private Boolean transportRequested;
    private Boolean transportOrdered;

    TransportPreparationSaga(UUID sagaId) {
        this.sagaId = sagaId;
    }

    UUID getSagaId() {
        return sagaId;
    }

    boolean isCompleted() {
        return false;
    }

    void listen(ProductSoldPivotalEvent event, TransportServiceClient transportServiceClient, WarehouseServiceClient warehouseServiceClient) {
        assortmentId = event.assortmentId();
        productId = event.productId();
        quantity = event.quantity();
        transportServiceClient.publish(new OrderTransportCommand(CommandId.next(event.eventId()), productId, quantity));
        warehouseServiceClient.publish(new PreparePackageCommand(CommandId.next(event.eventId()), productId, quantity));
        transportRequested = true;
        packagePreparationRequested = true;
    }

    void listen(TransportOrderedPivotalEvent event) {
        transportOrdered = true;
    }

    void listen(PackagePreparedPivotalEvent event) {
        packagePrepared = true;
    }
}
