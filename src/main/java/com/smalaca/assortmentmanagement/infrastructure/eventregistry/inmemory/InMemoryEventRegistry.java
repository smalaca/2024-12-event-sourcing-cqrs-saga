package com.smalaca.assortmentmanagement.infrastructure.eventregistry.inmemory;

import com.smalaca.assortmentmanagement.application.eventregistry.EventRegistry;
import com.smalaca.assortmentmanagement.domain.assortment.event.AssortmentEvent;
import com.smalaca.assortmentmanagement.infrastructure.repository.inmemory.assortment.InMemoryAssortmentRepository;
import org.springframework.stereotype.Component;

@Component
public class InMemoryEventRegistry implements EventRegistry {
    private final InMemoryAssortmentRepository repository;

    InMemoryEventRegistry(InMemoryAssortmentRepository repository) {
        this.repository = repository;
    }

    @Override
    public void publish(AssortmentEvent event) {
        repository.save(event);
    }
}
