package com.smalaca.assortmentmanagementcommand.domain.assortment;

import java.util.UUID;

public interface AssortmentRepository {
    boolean existFor(UUID sellerId, String name);

    Assortment findBy(UUID assortmentId);
}
