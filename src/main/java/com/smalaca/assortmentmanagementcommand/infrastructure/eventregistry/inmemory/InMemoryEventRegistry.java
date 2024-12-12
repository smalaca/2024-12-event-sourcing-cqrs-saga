package com.smalaca.assortmentmanagementcommand.infrastructure.eventregistry.inmemory;

import com.smalaca.assortmentmanagementcommand.application.eventregistry.EventRegistry;
import com.smalaca.assortmentmanagementcommand.domain.assortment.event.AssortmentEvent;
import com.smalaca.assortmentmanagementcommand.infrastructure.api.event.inmemory.assortment.AssortmentEventPublisher;
import com.smalaca.assortmentmanagementcommand.infrastructure.repository.inmemory.assortment.InMemoryAssortmentRepository;
import org.springframework.stereotype.Component;

@Component
public class InMemoryEventRegistry implements EventRegistry {
    private final InMemoryAssortmentRepository repository;
    private final AssortmentEventPublisher assortmentEventPublisher;

    InMemoryEventRegistry(InMemoryAssortmentRepository repository, AssortmentEventPublisher assortmentEventPublisher) {
        this.repository = repository;
        this.assortmentEventPublisher = assortmentEventPublisher;
    }

    @Override
    public void publish(AssortmentEvent event) {
        repository.save(event);
        // outbox pattern - new transaction
        assortmentEventPublisher.publish(event);
    }
}
