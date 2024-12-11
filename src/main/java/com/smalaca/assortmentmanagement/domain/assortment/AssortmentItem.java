package com.smalaca.assortmentmanagement.domain.assortment;

class AssortmentItem {
    private final Product product;
    private Quantity quantity;

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

    boolean hasNotLessThan(Quantity quantity) {
        return this.quantity.isNotLowerThan(quantity);
    }

    void sell(Quantity quantity) {
        this.quantity = this.quantity.reducedBy(quantity);
    }
}
