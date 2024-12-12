package com.smalaca.assortmentmanagementcommand.domain.assortment;

import java.util.UUID;

class AssortmentNameAlreadyUsedException extends RuntimeException {
    private final UUID sellerId;
    private final String name;

    AssortmentNameAlreadyUsedException(UUID sellerId, String name) {
        this.sellerId = sellerId;
        this.name = name;
    }
}
