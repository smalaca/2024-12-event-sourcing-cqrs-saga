package com.smalaca.bankaccountcommand.infrastructure.eventregistry.inmemory;

import com.smalaca.bankaccountcommand.application.eventregistry.EventRegistry;
import com.smalaca.bankaccountcommand.domain.bankaccount.event.BankAccountEvent;
import com.smalaca.bankaccountcommand.domain.bankaccount.event.NotEnoughMoneyRecognizedEvent;
import com.smalaca.bankaccountcommand.infrastructure.api.event.inmemory.bankaccount.BankAccountEventPublisher;
import com.smalaca.bankaccountcommand.infrastructure.repository.inmemory.bankaccount.InMemoryBankAccountRepository;
import org.springframework.stereotype.Service;

@Service
public class InMemoryEventRegistry implements EventRegistry {
    private final InMemoryBankAccountRepository repository;
    private final BankAccountEventPublisher bankAccountEventPublisher;
    private final BankAccountPivotalEventPublisher bankAccountPivotalEventPublisher;

    InMemoryEventRegistry(InMemoryBankAccountRepository repository, BankAccountEventPublisher bankAccountEventPublisher, BankAccountPivotalEventPublisher bankAccountPivotalEventPublisher) {
        this.repository = repository;
        this.bankAccountEventPublisher = bankAccountEventPublisher;
        this.bankAccountPivotalEventPublisher = bankAccountPivotalEventPublisher;
    }

    @Override
    public void publish(BankAccountEvent event) {
        System.out.println(event);
        repository.save(event);
        // outbox pattern
        bankAccountEventPublisher.listen(event);

        if (event instanceof NotEnoughMoneyRecognizedEvent) {
            bankAccountPivotalEventPublisher.listen((NotEnoughMoneyRecognizedEvent) event);
        }
    }
}
