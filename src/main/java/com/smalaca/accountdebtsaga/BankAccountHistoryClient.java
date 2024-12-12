package com.smalaca.accountdebtsaga;

import com.smalaca.bankaccounthistoryservice.AnalyzeBankAccountCommand;
import com.smalaca.bankaccounthistoryservice.BankAccountHistoryService;
import org.springframework.stereotype.Component;

@Component
class BankAccountHistoryClient {
    private final BankAccountHistoryService service;

    BankAccountHistoryClient(BankAccountHistoryService service) {
        this.service = service;
    }

    void publish(AnalyzeBankAccountCommand command) {
        service.handle(command);
    }
}
