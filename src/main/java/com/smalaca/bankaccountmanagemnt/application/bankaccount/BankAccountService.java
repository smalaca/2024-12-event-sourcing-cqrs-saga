package com.smalaca.bankaccountmanagemnt.application.bankaccount;

import com.smalaca.bankaccountmanagemnt.application.eventregistry.EventRegistry;
import com.smalaca.bankaccountmanagemnt.domain.bankaccount.BankAccount;
import com.smalaca.bankaccountmanagemnt.domain.bankaccount.BankAccountFactory;
import com.smalaca.bankaccountmanagemnt.domain.bankaccount.BankAccountRepository;
import com.smalaca.bankaccountmanagemnt.domain.bankaccount.command.CreateBankAccountCommand;
import com.smalaca.bankaccountmanagemnt.domain.bankaccount.command.DepositMoneyCommand;
import com.smalaca.bankaccountmanagemnt.domain.bankaccount.command.WithdrawMoneyCommand;
import com.smalaca.bankaccountmanagemnt.domain.bankaccount.event.BankAccountCreatedEvent;
import com.smalaca.bankaccountmanagemnt.domain.bankaccount.event.BankAccountEvent;
import com.smalaca.bankaccountmanagemnt.domain.bankaccount.event.MoneyDepositedEvent;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class BankAccountService {
    private final EventRegistry eventRegistry;
    private final BankAccountRepository bankAccountRepository;

    public BankAccountService(EventRegistry eventRegistry, BankAccountRepository bankAccountRepository) {
        this.eventRegistry = eventRegistry;
        this.bankAccountRepository = bankAccountRepository;
    }

    public UUID handle(CreateBankAccountCommand command) {
        // odczyt agregatu i tłumaczenie na wzorce DDD [0 ... *]


        // interakcja z agregatem - 1
        BankAccountCreatedEvent event = new BankAccountFactory().create(command);

        // publikacja zdarzenia - 1
        eventRegistry.publish(event);
        return event.bankAccountId();
    }

    public void handle(DepositMoneyCommand command) {
        BankAccount bankAccount = bankAccountRepository.findBy(command.bankAccountId());

        MoneyDepositedEvent event = bankAccount.deposit(command);

        eventRegistry.publish(event);
    }

    public void handle(WithdrawMoneyCommand command) {
        BankAccount bankAccount = bankAccountRepository.findBy(command.bankAccountId());

        BankAccountEvent event = bankAccount.withdraw(command);

        eventRegistry.publish(event);
    }
}
