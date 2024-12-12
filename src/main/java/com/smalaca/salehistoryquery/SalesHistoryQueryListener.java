package com.smalaca.salehistoryquery;

import com.smalaca.assortmentmanagementcommand.infrastructure.api.event.inmemory.assortment.ProductSoldPivotalEvent;
import org.springframework.stereotype.Component;

@Component
public class SalesHistoryQueryListener {
    private final SaleRepository repository;

    SalesHistoryQueryListener(SaleRepository repository) {
        this.repository = repository;
    }

    public void listen(ProductSoldPivotalEvent event) {
        SaleDataModel sale = new SaleDataModel();
        sale.setSaleId(saleId(event));
        sale.setAssortmentId(event.assortmentId());
        sale.setProductId(event.productId());
        sale.setQuantity(event.quantity());

        repository.save(sale);
    }

    private String saleId(ProductSoldPivotalEvent event) {
        return event.assortmentId() + event.version().toString();
    }
}
