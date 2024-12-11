package com.smalaca.assortmentmanagement.domain.assortment;

import com.smalaca.assortmentmanagement.domain.assortment.command.AddProductCommand;
import com.smalaca.assortmentmanagement.domain.assortment.command.ChangeProductPriceCommand;
import com.smalaca.assortmentmanagement.domain.assortment.event.AssortmentAdded;
import com.smalaca.assortmentmanagement.domain.assortment.event.AssortmentEvent;
import com.smalaca.assortmentmanagement.domain.assortment.event.ProductAddedEvent;
import com.smalaca.assortmentmanagement.domain.assortment.event.ProductPriceChangedEvent;
import com.smalaca.assortmentmanagement.domain.assortment.event.UnsupportedProductRecognizedEvent;
import com.smalaca.assortmentmanagement.domain.eventid.EventId;
import com.smalaca.assortmentmanagement.domain.productsupport.ProductSupportService;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Assortment {
    private UUID assortmentId;
    private UUID sellerId;
    private String name;
    private String description;
    private Map<UUID, AssortmentItem> products = new HashMap<>();

    public void listen(AssortmentAdded event) {
        assortmentId = event.assortmentId();
        sellerId = event.sellerId();
        name = event.name();
        description = event.description();
    }

    public AssortmentEvent addProduct(AddProductCommand command, ProductSupportService productSupportService) {
        if (productSupportService.isSupported(command.productIdentifier())) {
            ProductAddedEvent event = new ProductAddedEvent(
                    EventId.nextAfter(command.commandId()),
                    assortmentId,
                    createProductId(),
                    command.productIdentifier(),
                    command.name(),
                    command.price(),
                    command.quantity()
            );

            listen(event);
            return event;
        } else {
            UnsupportedProductRecognizedEvent event = new UnsupportedProductRecognizedEvent(
                    EventId.nextAfter(command.commandId()),
                    assortmentId,
                    command.productIdentifier());

            listen(event);
            return event;
        }
    }

    private UUID createProductId() {
        return UUID.randomUUID();
    }

    public void listen(ProductAddedEvent event) {
        Price price = Price.of(event.price());
        Product product = new Product(event.productId(), event.productIdentifier(), event.name(), price);
        Quantity quantity = Quantity.of(event.quantity());
        AssortmentItem products = new AssortmentItem(product, quantity);

        this.products.put(event.productId(), products);
    }

    public ProductPriceChangedEvent changeProductPrice(ChangeProductPriceCommand command) {
        ProductPriceChangedEvent event = new ProductPriceChangedEvent(
                EventId.nextAfter(command.commandId()),
                assortmentId,
                command.productId(),
                findItemBy(command.productId()).price().value(),
                command.price()
        );

        listen(event);

        return event;
    }

    public void listen(ProductPriceChangedEvent event) {
        AssortmentItem item = findItemBy(event.productId());
        Price price = Price.of(event.newPrice());
        item.change(price);
    }

    private AssortmentItem findItemBy(UUID productId) {
        return products.get(productId);
    }

    public void listen(UnsupportedProductRecognizedEvent event) {

    }
}
