package com.smalaca.assortmentmanagement.domain.assortment;

class AssortmentItem {
    private final Product product;
    private final int quantity;

    AssortmentItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    int price() {
        return product.price();
    }

    void changePrice(int price) {
        product.changePrice(price);
    }
}
