package com.smalaca.assortmentmanagement.domain.assortment.event;

import com.smalaca.assortmentmanagement.domain.assortment.Assortment;
import com.smalaca.assortmentmanagement.domain.eventid.EventId;

import java.time.LocalDateTime;
import java.util.UUID;

public record AssortmentAddedEvent(EventId eventId, UUID assortmentId, UUID sellerId, String name, String description) implements AssortmentEvent {
    @Override
    public LocalDateTime creationDateTime() {
        return eventId().creationDateTime();
    }

    @Override
    public void visit(Assortment assortment) {
        assortment.listen(this);
    }
}