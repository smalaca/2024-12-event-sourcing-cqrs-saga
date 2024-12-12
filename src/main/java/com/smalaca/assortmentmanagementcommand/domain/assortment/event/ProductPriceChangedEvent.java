package com.smalaca.assortmentmanagementcommand.domain.assortment.event;

import com.smalaca.assortmentmanagementcommand.domain.assortment.Assortment;
import com.smalaca.sharedkernel.eventid.EventId;

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
