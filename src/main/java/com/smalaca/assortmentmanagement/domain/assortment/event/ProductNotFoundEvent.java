package com.smalaca.assortmentmanagement.domain.assortment.event;

import com.smalaca.assortmentmanagement.domain.assortment.Assortment;
import com.smalaca.assortmentmanagement.domain.assortment.command.SellProductCommand;
import com.smalaca.assortmentmanagement.domain.eventid.EventId;

import java.time.LocalDateTime;
import java.util.UUID;

public record ProductNotFoundEvent(EventId eventId, UUID assortmentId, UUID productId, int quantity) implements AssortmentEvent {
    public static ProductNotFoundEvent create(SellProductCommand command, UUID assortmentId) {
        return new ProductNotFoundEvent(
                EventId.nextAfter(command.commandId()),
                assortmentId,
                command.productId(),
                command.quantity());
    }

    @Override
    public LocalDateTime creationDateTime() {
        return eventId().creationDateTime();
    }

    @Override
    public void visit(Assortment assortment) {
        assortment.listen(this);
    }
}
