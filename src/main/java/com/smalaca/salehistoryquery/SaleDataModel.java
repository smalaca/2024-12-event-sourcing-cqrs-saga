package com.smalaca.salehistoryquery;

import java.util.UUID;

public class SaleDataModel {
    private String saleId;
    private UUID assortmentId;
    private UUID productId;
    private int quantity;

    public String getSaleId() {
        return saleId;
    }

    void setSaleId(String saleId) {
        this.saleId = saleId;
    }

    public UUID getAssortmentId() {
        return assortmentId;
    }

    void setAssortmentId(UUID assortmentId) {
        this.assortmentId = assortmentId;
    }

    public UUID getProductId() {
        return productId;
    }

    void setProductId(UUID productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
