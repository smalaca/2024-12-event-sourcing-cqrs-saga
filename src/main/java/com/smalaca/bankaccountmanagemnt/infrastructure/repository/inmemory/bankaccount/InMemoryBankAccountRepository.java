package com.smalaca.bankaccountmanagemnt.infrastructure.repository.inmemory.bankaccount;

import com.smalaca.bankaccountmanagemnt.domain.bankaccount.BankAccount;
import com.smalaca.bankaccountmanagemnt.domain.bankaccount.BankAccountRepository;
import com.smalaca.bankaccountmanagemnt.domain.bankaccount.event.BankAccountEvent;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Repository
public class InMemoryBankAccountRepository implements BankAccountRepository {
    private final Map<UUID, List<BankAccountEvent>> bankAccounts = new HashMap<>();

    public void save(BankAccountEvent event) {
        if (!bankAccounts.containsKey(event.bankAccountId())) {
            bankAccounts.put(event.bankAccountId(), new ArrayList<>());
        }

        bankAccounts.get(event.bankAccountId()).add(event);
    }

    public Map<UUID, List<BankAccountEvent>> findAll() {
        return bankAccounts;
    }

    @Override
    public BankAccount findBy(UUID bankAccountId) {
        BankAccount bankAccount = new BankAccount();
        bankAccounts.get(bankAccountId).stream()
                .sorted(Comparator.comparing(BankAccountEvent::creationDateTime))
                .forEach(event -> event.visit(bankAccount));

        return bankAccount;
    }

    public List<BankAccountEvent> findAllFor(UUID bankAccountId) {
        return bankAccounts.get(bankAccountId);
    }
}
