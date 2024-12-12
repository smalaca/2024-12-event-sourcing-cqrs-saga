package com.smalaca.assortmentquery;

import java.time.LocalDateTime;
import java.util.UUID;

public class AssortmentDataModel {
    private UUID assortmentId;
    private LocalDateTime lastUpdateAt;
    private UUID sellerId;
    private String name;
    private String description;

    public UUID getSaleId() {
        return assortmentId;
    }

    void setAssortmentId(UUID assortmentId) {
        this.assortmentId = assortmentId;
    }

    public LocalDateTime getLastUpdateAt() {
        return lastUpdateAt;
    }

    void setLastUpdateAt(LocalDateTime lastUpdateAt) {
        this.lastUpdateAt = lastUpdateAt;
    }

    public UUID getSellerId() {
        return sellerId;
    }

    void setSellerId(UUID sellerId) {
        this.sellerId = sellerId;
    }

    public String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    void setDescription(String description) {
        this.description = description;
    }

    boolean isOlderThan(LocalDateTime version) {
        return lastUpdateAt.isBefore(version);
    }
}
