package com.smalaca.bankaccountview;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("bank-account")
public class BankAccountQueryRestController {
    private final BankAccountDataModelRepository repository;

    BankAccountQueryRestController(BankAccountDataModelRepository repository) {
        this.repository = repository;
    }

    @GetMapping("{bankAccountId}")
    public BankAccountDataModel findById(@PathVariable UUID bankAccountId) {
        return repository.findById(bankAccountId);
    }
}
