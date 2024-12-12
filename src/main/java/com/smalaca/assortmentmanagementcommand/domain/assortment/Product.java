package com.smalaca.assortmentmanagementcommand.domain.assortment;

import java.util.UUID;

class Product {
    private final UUID productId;
    private final String productIdentifier;
    private final String name;
    private Price price;

    Product(UUID productId, String productIdentifier, String name, Price price) {
        this.productId = productId;
        this.productIdentifier = productIdentifier;
        this.name = name;
        this.price = price;
    }

    Price price() {
        return price;
    }

    void change(Price price) {
        this.price = price;
    }
}
