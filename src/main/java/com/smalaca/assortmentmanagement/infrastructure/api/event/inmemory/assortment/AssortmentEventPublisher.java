package com.smalaca.assortmentmanagement.infrastructure.api.event.inmemory.assortment;

import com.smalaca.assortmentmanagement.domain.assortment.event.AssortmentAddedEvent;
import com.smalaca.assortmentmanagement.domain.assortment.event.AssortmentEvent;
import com.smalaca.assortmentquery.AssortmentQueryListener;
import org.springframework.stereotype.Component;

@Component
public class AssortmentEventPublisher {
    private final AssortmentQueryListener assortmentQueryListener;

    AssortmentEventPublisher(AssortmentQueryListener assortmentQueryListener) {
        this.assortmentQueryListener = assortmentQueryListener;
    }

    public void publish(AssortmentEvent event) {
        if (event instanceof AssortmentAddedEvent) {
            AssortmentAddedExternalEvent externalEvent = AssortmentAddedExternalEvent.create((AssortmentAddedEvent) event);
            assortmentQueryListener.listen(externalEvent);
        }
    }
}
