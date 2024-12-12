package com.smalaca.salehistoryquery;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class SaleRepository {
    private final Map<String, SaleDataModel> sales = new HashMap<>();

    void save(SaleDataModel sale) {
        sales.put(sale.getSaleId(), sale);
    }
}
