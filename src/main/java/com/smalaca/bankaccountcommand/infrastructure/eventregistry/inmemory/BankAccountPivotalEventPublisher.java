package com.smalaca.bankaccountcommand.infrastructure.eventregistry.inmemory;

import com.smalaca.accountdebtsaga.AccountDebtSagaListener;
import com.smalaca.bankaccountcommand.domain.bankaccount.BankAccountDto;
import com.smalaca.bankaccountcommand.domain.bankaccount.event.NotEnoughMoneyRecognizedEvent;
import com.smalaca.bankaccountcommand.infrastructure.repository.inmemory.bankaccount.InMemoryBankAccountRepository;
import org.springframework.stereotype.Component;

@Component
class BankAccountPivotalEventPublisher {
    private final AccountDebtSagaListener listener;
    private final InMemoryBankAccountRepository repository;

    BankAccountPivotalEventPublisher(AccountDebtSagaListener listener, InMemoryBankAccountRepository repository) {
        this.listener = listener;
        this.repository = repository;
    }

    void listen(NotEnoughMoneyRecognizedEvent event) {
        BankAccountDto dto = repository.findBy(event.bankAccountId()).asDto();
        NotEnoughMoneyRecognizedPivotalEvent pivotalEvent = NotEnoughMoneyRecognizedPivotalEvent.create(event, dto.ownerId());
        listener.listen(pivotalEvent);
    }
}
