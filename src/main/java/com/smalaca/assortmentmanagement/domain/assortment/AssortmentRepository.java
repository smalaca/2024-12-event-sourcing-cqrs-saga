package com.smalaca.assortmentmanagement.domain.assortment;

import java.util.UUID;

public interface AssortmentRepository {
    boolean existFor(UUID sellerId, String name);
}
