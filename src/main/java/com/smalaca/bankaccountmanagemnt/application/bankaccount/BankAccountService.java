package com.smalaca.bankaccountmanagemnt.application.bankaccount;

import com.smalaca.bankaccountmanagemnt.application.eventregistry.EventRegistry;
import com.smalaca.bankaccountmanagemnt.domain.bankaccount.BankAccountFactory;
import com.smalaca.bankaccountmanagemnt.domain.bankaccount.command.CreateBankAccountCommand;
import com.smalaca.bankaccountmanagemnt.domain.bankaccount.event.BankAccountCreated;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class BankAccountService {
    private final EventRegistry eventRegistry;

    public BankAccountService(EventRegistry eventRegistry) {
        this.eventRegistry = eventRegistry;
    }

    public UUID create(CreateBankAccountCommand command) {
        // odczyt agregatu i tłumaczenie na wzorce DDD [0 ... *]


        // interakcja z agregatem - 1
        BankAccountCreated event = new BankAccountFactory().create(command);

        // publikacja zdarzenia - 1
        eventRegistry.publish(event);
        return event.bankAccountId();
    }
}
