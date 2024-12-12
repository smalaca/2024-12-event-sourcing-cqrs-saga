package com.smalaca.assortmentmanagementcommand.domain.assortment.event;

import com.smalaca.assortmentmanagementcommand.domain.assortment.Assortment;
import com.smalaca.assortmentmanagementcommand.domain.eventid.EventId;

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
