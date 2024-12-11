package com.smalaca.assortmentmanagement.infrastructure.repository.inmemory.assortment;

import com.smalaca.assortmentmanagement.domain.assortment.event.AssortmentEvent;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Repository
public class InMemoryAssortmentRepository {
    private final Map<UUID, List<AssortmentEvent>> assortmentEvents = new HashMap<>();

    public void save(AssortmentEvent event) {
        if (!assortmentEvents.containsKey(event.assortmentId())) {
            assortmentEvents.put(event.assortmentId(), new ArrayList<>());
        }

        assortmentEvents.get(event.assortmentId()).add(event);
    }
}
