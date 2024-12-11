package com.smalaca.assortmentmanagement.domain.assortment;

class AssortmentItem {
    private final Product product;
    private final Quantity quantity;

    AssortmentItem(Product product, Quantity quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    Price price() {
        return product.price();
    }

    void change(Price price) {
        product.change(price);
    }
}
