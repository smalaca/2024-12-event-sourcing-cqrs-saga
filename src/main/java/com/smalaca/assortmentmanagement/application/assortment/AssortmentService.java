package com.smalaca.assortmentmanagement.application.assortment;

import com.smalaca.assortmentmanagement.application.eventregistry.EventRegistry;
import com.smalaca.assortmentmanagement.domain.assortment.Assortment;
import com.smalaca.assortmentmanagement.domain.assortment.AssortmentFactory;
import com.smalaca.assortmentmanagement.domain.assortment.AssortmentRepository;
import com.smalaca.assortmentmanagement.domain.assortment.command.AddAssortmentCommand;
import com.smalaca.assortmentmanagement.domain.assortment.command.AddProductCommand;
import com.smalaca.assortmentmanagement.domain.assortment.event.AssortmentAdded;
import com.smalaca.assortmentmanagement.domain.assortment.event.ProductAddedEvent;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AssortmentService {
    private final AssortmentFactory factory;
    private final EventRegistry eventRegistry;
    private final AssortmentRepository assortmentRepository;

    AssortmentService(AssortmentFactory factory, EventRegistry eventRegistry, AssortmentRepository assortmentRepository) {
        this.factory = factory;
        this.eventRegistry = eventRegistry;
        this.assortmentRepository = assortmentRepository;
    }

    public UUID handle(AddAssortmentCommand command) {
        AssortmentAdded event = factory.create(command);

        eventRegistry.publish(event);
        return event.assortmentId();
    }

    public void handle(AddProductCommand command) {
        Assortment assortment = assortmentRepository.findBy(command.assortmentId());

        ProductAddedEvent event = assortment.handle(command);

        eventRegistry.publish(event);
    }
}
