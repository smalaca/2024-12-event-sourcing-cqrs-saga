package com.smalaca.assortmentmanagement.application.assortment;

import com.smalaca.assortmentmanagement.domain.assortment.AssortmentFactory;
import com.smalaca.assortmentmanagement.domain.assortment.command.AddAssortmentCommand;
import com.smalaca.assortmentmanagement.domain.assortment.event.AssortmentAdded;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AssortmentService {
    private final AssortmentFactory factory;

    AssortmentService(AssortmentFactory factory) {
        this.factory = factory;
    }

    public UUID add(AddAssortmentCommand command) {
        AssortmentAdded event = factory.create(command);

        return event.assortmentId();
    }
}
