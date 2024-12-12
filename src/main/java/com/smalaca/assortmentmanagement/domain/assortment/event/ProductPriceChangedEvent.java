package com.smalaca.assortmentmanagement.domain.assortment.event;

import com.smalaca.assortmentmanagement.domain.assortment.Assortment;
import com.smalaca.assortmentmanagement.domain.eventid.EventId;

import java.time.LocalDateTime;
import java.util.UUID;

public record ProductPriceChangedEvent(EventId eventId, UUID assortmentId, UUID productId, int oldPrice, int newPrice) implements AssortmentEvent {
    @Override
    public LocalDateTime creationDateTime() {
        return eventId().creationDateTime();
    }

    @Override
    public void visit(Assortment assortment) {
        assortment.listen(this);
    }
}