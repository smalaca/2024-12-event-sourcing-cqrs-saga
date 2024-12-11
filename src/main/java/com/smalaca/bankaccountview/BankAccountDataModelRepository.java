package com.smalaca.bankaccountview;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Repository
class BankAccountDataModelRepository {
    private final Map<UUID, BankAccountDataModel> bankAccounts = new HashMap<>();

    void save(BankAccountDataModel bankAccount) {
        bankAccounts.put(bankAccount.getBankAccountId(), bankAccount);
    }

    BankAccountDataModel findById(UUID bankAccountId) {
        return bankAccounts.get(bankAccountId);
    }

    boolean doesNotExist(UUID bankAccountId) {
        return bankAccounts.containsKey(bankAccountId);
    }
}
