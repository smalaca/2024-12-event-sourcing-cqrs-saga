package com.smalaca.warehouseservice;

import com.smalaca.sharedkernel.eventid.EventId;

import java.util.UUID;

public record PackagePreparedPivotalEvent(EventId eventId, UUID sagaId, UUID packageId) {
}
