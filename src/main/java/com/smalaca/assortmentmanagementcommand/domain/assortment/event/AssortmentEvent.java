package com.smalaca.assortmentmanagementcommand.domain.assortment.event;

import com.smalaca.assortmentmanagementcommand.domain.assortment.Assortment;

import java.time.LocalDateTime;
import java.util.UUID;

public interface AssortmentEvent {
    UUID assortmentId();
    LocalDateTime creationDateTime();
    void visit(Assortment assortment);
}
