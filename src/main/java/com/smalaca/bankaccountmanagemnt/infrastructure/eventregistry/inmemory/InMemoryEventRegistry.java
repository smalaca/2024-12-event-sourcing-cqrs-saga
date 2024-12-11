package com.smalaca.bankaccountmanagemnt.infrastructure.eventregistry.inmemory;

import com.smalaca.bankaccountmanagemnt.application.eventregistry.EventRegistry;
import com.smalaca.bankaccountmanagemnt.domain.bankaccount.event.BankAccountEvent;
import com.smalaca.bankaccountmanagemnt.infrastructure.repository.inmemory.bankaccount.InMemoryBankAccountRepository;
import org.springframework.stereotype.Service;

@Service
public class InMemoryEventRegistry implements EventRegistry {
    private final InMemoryBankAccountRepository repository;

    InMemoryEventRegistry(InMemoryBankAccountRepository repository) {
        this.repository = repository;
    }

    @Override
    public void publish(BankAccountEvent event) {
        repository.save(event);
    }
}
