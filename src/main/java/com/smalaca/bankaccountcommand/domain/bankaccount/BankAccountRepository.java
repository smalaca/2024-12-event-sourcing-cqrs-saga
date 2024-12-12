package com.smalaca.bankaccountcommand.domain.bankaccount;

import java.util.UUID;

public interface BankAccountRepository {
    BankAccount findBy(UUID bankAccountId);
}
