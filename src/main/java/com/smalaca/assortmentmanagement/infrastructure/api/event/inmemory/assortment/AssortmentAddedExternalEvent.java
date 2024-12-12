package com.smalaca.assortmentmanagement.infrastructure.api.event.inmemory.assortment;

import com.smalaca.assortmentmanagement.domain.assortment.event.AssortmentAddedEvent;
import com.smalaca.assortmentmanagement.domain.eventid.EventId;

import java.time.LocalDateTime;
import java.util.UUID;

public record AssortmentAddedExternalEvent(
        EventId eventId, LocalDateTime version, UUID assortmentId, UUID sellerId, String name, String description) {
    static AssortmentAddedExternalEvent create(AssortmentAddedEvent event) {
        return new AssortmentAddedExternalEvent(
                event.eventId().next(),
                event.creationDateTime(),
                event.assortmentId(),
                event.sellerId(),
                event.name(),
                event.description());
    }
}
