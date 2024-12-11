package com.smalaca.assortmentmanagement.domain.assortment;

class PriceException extends RuntimeException {
    private final int value;

    PriceException(int value) {
        this.value = value;
    }
}
