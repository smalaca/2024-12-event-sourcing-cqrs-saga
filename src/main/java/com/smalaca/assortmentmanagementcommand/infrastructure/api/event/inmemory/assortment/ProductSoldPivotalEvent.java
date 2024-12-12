package com.smalaca.assortmentmanagementcommand.infrastructure.api.event.inmemory.assortment;

import com.smalaca.assortmentmanagementcommand.domain.assortment.event.ProductSoldEvent;
import com.smalaca.sharedkernel.eventid.EventId;

import java.time.LocalDateTime;
import java.util.UUID;

public record ProductSoldPivotalEvent(
        EventId eventId, LocalDateTime version, UUID assortmentId, UUID productId, int quantity) {
    static ProductSoldPivotalEvent create(ProductSoldEvent event) {
        return new ProductSoldPivotalEvent(
                event.eventId().next(),
                event.creationDateTime(),
                event.assortmentId(),
                event.productId(),
                event.quantity());
    }
}
