package com.smalaca.bankaccountmanagemnt.domain.bankaccount.event;

import com.smalaca.bankaccountmanagemnt.domain.eventid.EventId;

import java.util.UUID;

public record BankAccountCreated(EventId eventId, UUID bankAccountId, UUID ownerId, UUID accountNumber, int balance) {
}
