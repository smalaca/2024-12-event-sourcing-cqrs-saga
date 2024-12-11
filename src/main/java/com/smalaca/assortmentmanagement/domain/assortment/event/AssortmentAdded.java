package com.smalaca.assortmentmanagement.domain.assortment.event;

import com.smalaca.assortmentmanagement.domain.eventid.EventId;

import java.util.UUID;

public record AssortmentAdded(EventId eventId, UUID assortmentId, UUID sellerId, String name, String description) implements AssortmentEvent {
}
