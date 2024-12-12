package com.smalaca.assortmentquery;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Repository
public class AssortmentDataModelRepository {
    private final Map<UUID, AssortmentDataModel> assortments = new HashMap<>();

    boolean doesNotExist(UUID assortmentId) {
        return !assortments.containsKey(assortmentId);
    }

    void save(AssortmentDataModel assortment) {
        assortments.put(assortment.getSaleId(), assortment);
    }

    AssortmentDataModel findById(UUID assortmentId) {
        return assortments.get(assortmentId);
    }
}
