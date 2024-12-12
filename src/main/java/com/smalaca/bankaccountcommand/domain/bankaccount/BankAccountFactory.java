package com.smalaca.bankaccountcommand.domain.bankaccount;

import com.smalaca.bankaccountcommand.domain.bankaccount.command.CreateBankAccountCommand;
import com.smalaca.bankaccountcommand.domain.bankaccount.event.BankAccountOpenedEvent;
import com.smalaca.bankaccountcommand.domain.eventid.EventId;
import net.datafaker.Faker;

import java.util.UUID;

public class BankAccountFactory {
    private static final int INITIAL_BALANCE = 0;
    private static final Faker FAKER = new Faker();


    public BankAccountOpenedEvent create(CreateBankAccountCommand command) {
        return new BankAccountOpenedEvent(
                EventId.nextAfter(command.commandId()),
                bankAccountId(),
                command.ownerId(),
                accountNumber(),
                INITIAL_BALANCE);
    }

    private UUID bankAccountId() {
        return UUID.randomUUID();
    }

    private String accountNumber() {
        return FAKER.number().digits(13);
    }
}
