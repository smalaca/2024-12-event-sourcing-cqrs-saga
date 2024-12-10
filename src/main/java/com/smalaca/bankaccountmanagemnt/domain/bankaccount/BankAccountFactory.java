package com.smalaca.bankaccountmanagemnt.domain.bankaccount;

import com.smalaca.bankaccountmanagemnt.domain.bankaccount.command.CreateBankAccountCommand;
import com.smalaca.bankaccountmanagemnt.domain.bankaccount.event.BankAccountCreated;
import com.smalaca.bankaccountmanagemnt.domain.eventid.EventId;
import net.datafaker.Faker;

import java.util.UUID;

public class BankAccountFactory {
    private static final int INITIAL_BALANCE = 0;
    private static final Faker FAKER = new Faker();


    public BankAccountCreated create(CreateBankAccountCommand command) {
        return new BankAccountCreated(
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
