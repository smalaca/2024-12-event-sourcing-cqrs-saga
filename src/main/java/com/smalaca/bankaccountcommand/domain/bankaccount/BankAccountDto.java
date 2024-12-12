package com.smalaca.bankaccountcommand.domain.bankaccount;

import java.util.UUID;

public record BankAccountDto(UUID bankAccountId, UUID ownerId) {
}
