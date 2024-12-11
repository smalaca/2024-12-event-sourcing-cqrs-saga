package com.smalaca.assortmentmanagement.domain.assortment;

class Quantity {
    private final int value;

    private Quantity(int value) {
        this.value = value;
    }

    static Quantity of(int value) {
        if (value < 1) {
            throw new QuantityException(value);
        }
        return new Quantity(value);
    }

    boolean isNotLowerThan(Quantity quantity) {
        return value >= quantity.value;
    }

    Quantity reducedBy(Quantity quantity) {
        return Quantity.of(value - quantity.value);
    }
}
