package com.smalaca.bankaccountmanagemnt.infrastructure.api.rest.bankaccount;

import com.smalaca.bankaccountmanagemnt.application.bankaccount.BankAccountService;
import com.smalaca.bankaccountmanagemnt.domain.bankaccount.command.CreateBankAccountCommand;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("bank-account")
public class BankAccountRestController {
    private final BankAccountService bankAccountService;

    BankAccountRestController(BankAccountService bankAccountService) {
        this.bankAccountService = bankAccountService;
    }

    @PostMapping
    public UUID create(CreateBankAccountCommand command) {
        return bankAccountService.create(command);
    }
}
