package com.smalaca.assortmentmanagement.application.assortment;

import com.smalaca.assortmentmanagement.application.eventregistry.EventRegistry;
import com.smalaca.assortmentmanagement.domain.assortment.AssortmentFactory;
import com.smalaca.assortmentmanagement.domain.assortment.command.AddAssortmentCommand;
import com.smalaca.assortmentmanagement.domain.assortment.event.AssortmentAdded;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AssortmentService {
    private final AssortmentFactory factory;
    private final EventRegistry eventRegistry;

    AssortmentService(AssortmentFactory factory, EventRegistry eventRegistry) {
        this.factory = factory;
        this.eventRegistry = eventRegistry;
    }

    public UUID add(AddAssortmentCommand command) {
        AssortmentAdded event = factory.create(command);

        eventRegistry.publish(event);
        return event.assortmentId();
    }
}
