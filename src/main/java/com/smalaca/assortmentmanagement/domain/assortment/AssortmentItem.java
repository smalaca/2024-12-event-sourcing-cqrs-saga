package com.smalaca.assortmentmanagement.domain.assortment;

class AssortmentItem {
    private final Product product;
    private final int quantity;

    AssortmentItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }
}
