package com.smalaca.assortmentmanagementcommand.infrastructure.repository.inmemory.assortment;

import com.smalaca.assortmentmanagementcommand.domain.assortment.Assortment;
import com.smalaca.assortmentmanagementcommand.domain.assortment.AssortmentRepository;
import com.smalaca.assortmentmanagementcommand.domain.assortment.event.AssortmentEvent;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Repository
public class InMemoryAssortmentRepository implements AssortmentRepository {
    private final Map<UUID, List<AssortmentEvent>> assortmentEvents = new HashMap<>();

    public void save(AssortmentEvent event) {
        if (!assortmentEvents.containsKey(event.assortmentId())) {
            assortmentEvents.put(event.assortmentId(), new ArrayList<>());
        }

        assortmentEvents.get(event.assortmentId()).add(event);
    }

    @Override
    public boolean existFor(UUID sellerId, String name) {
        // dummy implementation
        return false;
    }

    @Override
    public Assortment findBy(UUID assortmentId) {
        Assortment assortment = new Assortment();
        assortmentEvents.get(assortmentId).stream()
                .sorted(Comparator.comparing(AssortmentEvent::creationDateTime))
                .forEach(event -> event.visit(assortment));

        return assortment;
    }
}
