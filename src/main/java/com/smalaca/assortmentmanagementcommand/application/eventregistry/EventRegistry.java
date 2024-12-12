package com.smalaca.assortmentmanagementcommand.application.eventregistry;

import com.smalaca.assortmentmanagementcommand.domain.assortment.event.AssortmentEvent;

public interface EventRegistry {
    void publish(AssortmentEvent event);
}
