package com.smalaca.bankaccountmanagemnt.domain.bankaccount;

import java.util.UUID;

public record BankAccountDto(UUID bankAccountId, UUID ownerId, String accountNumber, int balance) {
}
