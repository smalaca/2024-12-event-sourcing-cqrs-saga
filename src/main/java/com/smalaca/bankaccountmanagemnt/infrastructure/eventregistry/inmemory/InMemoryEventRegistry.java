package com.smalaca.bankaccountmanagemnt.infrastructure.eventregistry.inmemory;

import com.smalaca.bankaccountmanagemnt.application.eventregistry.EventRegistry;
import com.smalaca.bankaccountmanagemnt.domain.bankaccount.event.BankAccountEvent;
import com.smalaca.bankaccountmanagemnt.infrastructure.api.event.inmemory.bankaccount.BankAccountEventPublisher;
import com.smalaca.bankaccountmanagemnt.infrastructure.repository.inmemory.bankaccount.InMemoryBankAccountRepository;
import org.springframework.stereotype.Service;

@Service
public class InMemoryEventRegistry implements EventRegistry {
    private final InMemoryBankAccountRepository repository;
    private final BankAccountEventPublisher bankAccountEventPublisher;

    InMemoryEventRegistry(InMemoryBankAccountRepository repository, BankAccountEventPublisher bankAccountEventPublisher) {
        this.repository = repository;
        this.bankAccountEventPublisher = bankAccountEventPublisher;
    }

    @Override
    public void publish(BankAccountEvent event) {
        System.out.println(event);
        repository.save(event);
        // outbox pattern
        bankAccountEventPublisher.listen(event);
    }
}
