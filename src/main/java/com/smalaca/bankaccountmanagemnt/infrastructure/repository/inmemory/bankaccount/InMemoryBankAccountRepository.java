package com.smalaca.bankaccountmanagemnt.infrastructure.repository.inmemory.bankaccount;

import com.smalaca.bankaccountmanagemnt.domain.bankaccount.event.BankAccountCreated;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Repository
public class InMemoryBankAccountRepository {
    private final Map<UUID, Object> bankAccounts = new HashMap<>();

    public void save(BankAccountCreated event) {
        bankAccounts.put(event.bankAccountId(), event);
    }

    public Map<UUID, Object> findAll() {
        return bankAccounts;
    }
}
