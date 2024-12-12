package com.smalaca.assortmentmanagementcommand.domain.assortment.event;

import com.smalaca.assortmentmanagementcommand.domain.assortment.Assortment;
import com.smalaca.assortmentmanagementcommand.domain.eventid.EventId;

import java.time.LocalDateTime;
import java.util.UUID;

public record ProductAddedEvent(EventId eventId, UUID assortmentId, UUID productId, String productIdentifier, String name, int price, int quantity) implements AssortmentEvent {
    @Override
    public LocalDateTime creationDateTime() {
        return eventId().creationDateTime();
    }

    @Override
    public void visit(Assortment assortment) {
        assortment.listen(this);
    }
}
