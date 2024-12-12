package com.smalaca.assortmentmanagementcommand.application.assortment;

import com.smalaca.assortmentmanagementcommand.application.eventregistry.EventRegistry;
import com.smalaca.assortmentmanagementcommand.domain.assortment.Assortment;
import com.smalaca.assortmentmanagementcommand.domain.assortment.AssortmentFactory;
import com.smalaca.assortmentmanagementcommand.domain.assortment.AssortmentRepository;
import com.smalaca.assortmentmanagementcommand.domain.assortment.command.AddAssortmentCommand;
import com.smalaca.assortmentmanagementcommand.domain.assortment.command.AddProductCommand;
import com.smalaca.assortmentmanagementcommand.domain.assortment.command.ChangeProductPriceCommand;
import com.smalaca.assortmentmanagementcommand.domain.assortment.command.SellProductCommand;
import com.smalaca.assortmentmanagementcommand.domain.assortment.event.AssortmentAddedEvent;
import com.smalaca.assortmentmanagementcommand.domain.assortment.event.AssortmentEvent;
import com.smalaca.assortmentmanagementcommand.domain.assortment.event.ProductPriceChangedEvent;
import com.smalaca.assortmentmanagementcommand.domain.productsupport.ProductSupportService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AssortmentService {
    private final AssortmentFactory factory;
    private final EventRegistry eventRegistry;
    private final AssortmentRepository assortmentRepository;
    private final ProductSupportService productSupportService;

    AssortmentService(
            AssortmentFactory factory, EventRegistry eventRegistry,
            AssortmentRepository assortmentRepository, ProductSupportService productSupportService) {
        this.factory = factory;
        this.eventRegistry = eventRegistry;
        this.assortmentRepository = assortmentRepository;
        this.productSupportService = productSupportService;
    }

    public UUID handle(AddAssortmentCommand command) {
        AssortmentAddedEvent event = factory.create(command);

        eventRegistry.publish(event);
        return event.assortmentId();
    }

    public void handle(AddProductCommand command) {
        Assortment assortment = assortmentRepository.findBy(command.assortmentId());

        AssortmentEvent event = assortment.addProduct(command, productSupportService);

        eventRegistry.publish(event);
    }

    public void handle(ChangeProductPriceCommand command) {
        Assortment assortment = assortmentRepository.findBy(command.assortmentId());

        ProductPriceChangedEvent event = assortment.changeProductPrice(command);

        eventRegistry.publish(event);
    }

    public void handle(SellProductCommand command) {
        Assortment assortment = assortmentRepository.findBy(command.assortmentId());

        AssortmentEvent event = assortment.sellProduct(command);

        eventRegistry.publish(event);
    }
}
