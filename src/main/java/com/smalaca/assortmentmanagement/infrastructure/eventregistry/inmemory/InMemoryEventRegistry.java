package com.smalaca.assortmentmanagement.infrastructure.eventregistry.inmemory;

import com.smalaca.assortmentmanagement.application.eventregistry.EventRegistry;
import com.smalaca.assortmentmanagement.domain.assortment.event.AssortmentEvent;
import com.smalaca.assortmentmanagement.infrastructure.api.event.inmemory.assortment.AssortmentEventPublisher;
import com.smalaca.assortmentmanagement.infrastructure.repository.inmemory.assortment.InMemoryAssortmentRepository;
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
