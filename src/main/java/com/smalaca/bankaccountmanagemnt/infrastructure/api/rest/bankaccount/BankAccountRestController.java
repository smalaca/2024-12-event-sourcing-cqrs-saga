package com.smalaca.bankaccountmanagemnt.infrastructure.api.rest.bankaccount;

import com.smalaca.bankaccountmanagemnt.application.bankaccount.BankAccountService;
import com.smalaca.bankaccountmanagemnt.domain.bankaccount.command.CreateBankAccountCommand;
import com.smalaca.bankaccountmanagemnt.infrastructure.repository.inmemory.bankaccount.InMemoryBankAccountRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("bank-account")
public class BankAccountRestController {
    private final BankAccountService bankAccountService;
    private final InMemoryBankAccountRepository repository;

    BankAccountRestController(BankAccountService bankAccountService, InMemoryBankAccountRepository repository) {
        this.bankAccountService = bankAccountService;
        this.repository = repository;
    }

    @PostMapping
    public UUID create(@RequestBody CreateBankAccountCommand command) {
        return bankAccountService.handle(command);
    }

    @GetMapping("events")
    public Map<UUID, Object> allEvents() {
        return repository.findAll();
    }
}
