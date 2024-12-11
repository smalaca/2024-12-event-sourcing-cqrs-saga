package com.smalaca.assortmentmanagement.domain.assortment;

class QuantityException extends RuntimeException {
    private final int value;

    QuantityException(int value) {
        this.value = value;
    }
}
