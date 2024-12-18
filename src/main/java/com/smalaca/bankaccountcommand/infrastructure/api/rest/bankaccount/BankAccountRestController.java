package com.smalaca.bankaccountcommand.infrastructure.api.rest.bankaccount;

import com.smalaca.bankaccountcommand.application.bankaccount.BankAccountService;
import com.smalaca.bankaccountcommand.domain.bankaccount.command.CreateBankAccountCommand;
import com.smalaca.bankaccountcommand.domain.bankaccount.command.DepositMoneyCommand;
import com.smalaca.bankaccountcommand.domain.bankaccount.command.WithdrawMoneyCommand;
import com.smalaca.bankaccountcommand.domain.bankaccount.event.BankAccountEvent;
import com.smalaca.bankaccountcommand.infrastructure.repository.inmemory.bankaccount.InMemoryBankAccountRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
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

    @PutMapping("deposit")
    public void deposit(@RequestBody DepositMoneyCommand command) {
        bankAccountService.handle(command);
    }

    @PutMapping("withdraw")
    public void withdraw(@RequestBody WithdrawMoneyCommand command) {
        bankAccountService.handle(command);
    }

    @GetMapping("events")
    public Map<UUID, List<BankAccountEvent>> allEvents() {
        return repository.findAll();
    }

    @GetMapping("events/{bankAccountId}")
    public List<BankAccountEvent> allEventsForBankAccount(@PathVariable UUID bankAccountId) {
        return repository.findAllFor(bankAccountId);
    }
}
