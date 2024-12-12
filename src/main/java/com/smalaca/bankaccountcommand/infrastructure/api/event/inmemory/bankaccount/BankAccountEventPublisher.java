package com.smalaca.bankaccountcommand.infrastructure.api.event.inmemory.bankaccount;

import com.smalaca.accountdebtsaga.AccountDebtSagaListener;
import com.smalaca.bankaccountcommand.domain.bankaccount.BankAccountDto;
import com.smalaca.bankaccountcommand.domain.bankaccount.event.BankAccountOpenedEvent;
import com.smalaca.bankaccountcommand.domain.bankaccount.event.BankAccountEvent;
import com.smalaca.bankaccountcommand.domain.bankaccount.event.MoneyDepositedEvent;
import com.smalaca.bankaccountcommand.domain.bankaccount.event.MoneyWithdrawnEvent;
import com.smalaca.bankaccountcommand.domain.bankaccount.event.NotEnoughMoneyRecognizedEvent;
import com.smalaca.bankaccountcommand.infrastructure.repository.inmemory.bankaccount.InMemoryBankAccountRepository;
import com.smalaca.bankaccountquery.BankAccountQueryListener;
import org.springframework.stereotype.Service;

@Service
public class BankAccountEventPublisher {
    private final AccountDebtSagaListener accountDebtSagaListener;
    private final InMemoryBankAccountRepository bankAccountRepository;
    private final BankAccountQueryListener bankAccountQueryListener;

    BankAccountEventPublisher(
            AccountDebtSagaListener accountDebtSagaListener, InMemoryBankAccountRepository bankAccountRepository, BankAccountQueryListener bankAccountQueryListener) {
        this.accountDebtSagaListener = accountDebtSagaListener;
        this.bankAccountRepository = bankAccountRepository;
        this.bankAccountQueryListener = bankAccountQueryListener;
    }

    public void listen(BankAccountEvent event) {
        if (event instanceof BankAccountOpenedEvent) {
            BankAccountOpenedExternalEvent externalEvent = BankAccountOpenedExternalEvent.create((BankAccountOpenedEvent) event);
            System.out.println(externalEvent);
            bankAccountQueryListener.listen(externalEvent);

        } else if (event instanceof MoneyDepositedEvent) {
            TransactionMadeExternalEvent externalEvent = TransactionMadeExternalEvent.create((MoneyDepositedEvent) event);
            System.out.println(externalEvent);
            bankAccountQueryListener.listen(externalEvent);

        } else if (event instanceof MoneyWithdrawnEvent) {
            TransactionMadeExternalEvent externalEvent = TransactionMadeExternalEvent.create((MoneyWithdrawnEvent) event);
            System.out.println(externalEvent);
            bankAccountQueryListener.listen(externalEvent);
        } else if (event instanceof NotEnoughMoneyRecognizedEvent) {
            BankAccountDto dto = bankAccountRepository.findBy(event.bankAccountId()).asDto();
            NotEnoughMoneyRecognizedPivotalEvent pivotalEvent = NotEnoughMoneyRecognizedPivotalEvent.create((NotEnoughMoneyRecognizedEvent) event, dto.ownerId());
            accountDebtSagaListener.listen(pivotalEvent);
        }
    }
}
