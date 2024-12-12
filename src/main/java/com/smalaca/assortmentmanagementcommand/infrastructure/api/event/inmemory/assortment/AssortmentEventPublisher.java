package com.smalaca.assortmentmanagementcommand.infrastructure.api.event.inmemory.assortment;

import com.smalaca.assortmentmanagementcommand.domain.assortment.event.AssortmentAddedEvent;
import com.smalaca.assortmentmanagementcommand.domain.assortment.event.AssortmentEvent;
import com.smalaca.assortmentmanagementcommand.domain.assortment.event.ProductSoldEvent;
import com.smalaca.assortmentquery.AssortmentQueryListener;
import com.smalaca.salehistoryquery.SalesHistoryQueryListener;
import com.smalaca.transportpreparationsaga.TransportPreparationSagaListener;
import org.springframework.stereotype.Component;

@Component
public class AssortmentEventPublisher {
    private final AssortmentQueryListener assortmentQueryListener;
    private final SalesHistoryQueryListener salesHistoryQueryListener;
    private final TransportPreparationSagaListener transportPreparationSagaListener;

    AssortmentEventPublisher(
            AssortmentQueryListener assortmentQueryListener, SalesHistoryQueryListener salesHistoryQueryListener,
            TransportPreparationSagaListener transportPreparationSagaListener) {
        this.assortmentQueryListener = assortmentQueryListener;
        this.salesHistoryQueryListener = salesHistoryQueryListener;
        this.transportPreparationSagaListener = transportPreparationSagaListener;
    }

    public void publish(AssortmentEvent event) {
        if (event instanceof AssortmentAddedEvent) {
            AssortmentAddedExternalEvent externalEvent = AssortmentAddedExternalEvent.create((AssortmentAddedEvent) event);
            assortmentQueryListener.listen(externalEvent);
        } else if (event instanceof ProductSoldEvent) {
            ProductSoldPivotalEvent pivotalEvent = ProductSoldPivotalEvent.create((ProductSoldEvent) event);
            salesHistoryQueryListener.listen(pivotalEvent);
            transportPreparationSagaListener.listen(pivotalEvent);
        }
    }
}
