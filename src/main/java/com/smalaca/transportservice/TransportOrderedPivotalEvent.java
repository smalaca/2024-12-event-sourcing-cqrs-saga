package com.smalaca.transportservice;

import com.smalaca.sharedkernel.eventid.EventId;

import java.util.UUID;

public record TransportOrderedPivotalEvent(EventId eventId, UUID sagaId, UUID transportId) {
}
