package com.smalaca.assortmentmanagement.domain.assortment;

class Price {
    private final int value;

    private Price(int value) {
        this.value = value;
    }

    static Price of(int value) {
        if (value < 1) {
            throw new PriceException(value);
        }

        return new Price(value);
    }

    int value() {
        return value;
    }
}
