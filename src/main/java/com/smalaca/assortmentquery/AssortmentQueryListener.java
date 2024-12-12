package com.smalaca.assortmentquery;

import com.smalaca.assortmentmanagementcommand.infrastructure.api.event.inmemory.assortment.AssortmentAddedExternalEvent;
import com.smalaca.assortmentmanagementcommand.infrastructure.api.event.inmemory.assortment.ProductSoldPivotalEvent;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class AssortmentQueryListener {
    private final AssortmentDataModelRepository repository;

    AssortmentQueryListener(AssortmentDataModelRepository repository) {
        this.repository = repository;
    }

    public void listen(AssortmentAddedExternalEvent event) {
        AssortmentDataModel assortment = getOrCreate(event.assortmentId());
        assortment.setSellerId(event.sellerId());
        assortment.setDescription(event.description());
        assortment.setName(event.name());

        if (assortment.isOlderThan(event.version())) {
            assortment.setLastUpdateAt(event.version());
        }

        repository.save(assortment);
    }

    public void listen(ProductSoldPivotalEvent event) {
        AssortmentDataModel assortment = getOrCreate(event.assortmentId());

        if (assortment.isOlderThan(event.version())) {
//            assortment.setQuantityFor(event.productId(), event.quantity());
            assortment.setLastUpdateAt(event.version());
        }

        repository.save(assortment);
    }

    private AssortmentDataModel getOrCreate(UUID assortmentId) {
        if (repository.doesNotExist(assortmentId)) {
            AssortmentDataModel assortment = new AssortmentDataModel();
            assortment.setAssortmentId(assortmentId);
            repository.save(assortment);
        }

        return repository.findById(assortmentId);
    }
}
