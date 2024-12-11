package com.smalaca.assortmentmanagement.domain.assortment;

import java.util.UUID;

class Product {
    private final UUID productId;
    private final String productIdentifier;
    private final String name;
    private final int price;

    Product(UUID productId, String productIdentifier, String name, int price) {
        this.productId = productId;
        this.productIdentifier = productIdentifier;
        this.name = name;
        this.price = price;
    }
}
