package com.smalaca.bankaccountview;

import com.smalaca.bankaccountmanagemnt.infrastructure.api.event.inmemory.bankaccount.BankAccountCreatedExternalEvent;
import com.smalaca.bankaccountmanagemnt.infrastructure.api.event.inmemory.bankaccount.BankAccountModifiedExternalEvent;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class BankAccountQueryListener {
    private final BankAccountDataModelRepository repository;

    BankAccountQueryListener(BankAccountDataModelRepository repository) {
        this.repository = repository;
    }

    public void listen(BankAccountCreatedExternalEvent event) {
        BankAccountDataModel bankAccount = getOrCreate(event.bankAccountId());
        bankAccount.setOwnerId(event.ownerId());
        bankAccount.setAccountNumber(event.accountNumber());

        if (bankAccount.isOlderThan(event.publicationDateTime())) {
            bankAccount.setBalance(event.balance());
        }

        repository.save(bankAccount);
    }

    public void listen(BankAccountModifiedExternalEvent event) {
        BankAccountDataModel bankAccount = getOrCreate(event.bankAccountId());

        if (bankAccount.isOlderThan(event.publicationDateTime())) {
            bankAccount.setBalance(event.balance());
            repository.save(bankAccount);
        }
    }

    private BankAccountDataModel getOrCreate(UUID bankAccountId) {
        if (repository.doesNotExist(bankAccountId)) {
            BankAccountDataModel bankAccount = new BankAccountDataModel();
            bankAccount.setBankAccountId(bankAccountId);
            repository.save(bankAccount);
        }

        return repository.findById(bankAccountId);
    }
}
