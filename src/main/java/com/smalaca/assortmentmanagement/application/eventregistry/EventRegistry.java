package com.smalaca.assortmentmanagement.application.eventregistry;

import com.smalaca.assortmentmanagement.domain.assortment.event.AssortmentEvent;

public interface EventRegistry {
    void publish(AssortmentEvent event);
}
