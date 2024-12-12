package com.smalaca.assortmentmanagementcommand.infrastructure.api.event.inmemory.assortment;

import com.smalaca.assortmentmanagementcommand.domain.assortment.event.ProductSoldEvent;
import com.smalaca.assortmentmanagementcommand.domain.eventid.EventId;

import java.time.LocalDateTime;
import java.util.UUID;

public record ProductSoldExternalEvent(
        EventId eventId, LocalDateTime version, UUID assortmentId, UUID productId, int quantity) {
    static ProductSoldExternalEvent create(ProductSoldEvent event) {
        return new ProductSoldExternalEvent(
                event.eventId().next(),
                event.creationDateTime(),
                event.assortmentId(),
                event.productId(),
                event.quantity());
    }
}
