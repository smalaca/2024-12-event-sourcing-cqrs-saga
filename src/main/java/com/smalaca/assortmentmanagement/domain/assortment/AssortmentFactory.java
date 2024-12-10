package com.smalaca.assortmentmanagement.domain.assortment;

import com.smalaca.assortmentmanagement.domain.assortment.command.AddAssortmentCommand;
import com.smalaca.assortmentmanagement.domain.assortment.event.AssortmentAdded;
import com.smalaca.assortmentmanagement.domain.eventid.EventId;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class AssortmentFactory {
    private final AssortmentRepository repository;

    AssortmentFactory(AssortmentRepository repository) {
        this.repository = repository;
    }

    public AssortmentAdded create(AddAssortmentCommand command) {
        return new AssortmentAdded(
                EventId.nextAfter(command.commandId()),
                assortmentId(),
                command.sellerId(),
                name(command),
                command.description()
        );
    }

    private String name(AddAssortmentCommand command) {
        if (repository.existFor(command.sellerId(), command.name())) {
            throw new AssortmentNameAlreadyUsedException(command.sellerId(), command.name());
        }

        return command.name();
    }

    private UUID assortmentId() {
        return UUID.randomUUID();
    }
}
