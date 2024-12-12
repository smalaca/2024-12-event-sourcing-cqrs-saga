package com.smalaca.salehistoryquery;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Repository
public class SaleRepository {
    private final Map<UUID, SaleDataModel> sales = new HashMap<>();

    void save(SaleDataModel sale) {
        sales.put(sale.getSaleId(), sale);
    }
}
