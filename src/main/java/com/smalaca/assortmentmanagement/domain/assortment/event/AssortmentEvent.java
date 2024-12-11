package com.smalaca.assortmentmanagement.domain.assortment.event;

import com.smalaca.assortmentmanagement.domain.assortment.Assortment;

import java.time.LocalDateTime;
import java.util.UUID;

public interface AssortmentEvent {
    UUID assortmentId();
    LocalDateTime creationDateTime();
    void visit(Assortment assortment);
}
