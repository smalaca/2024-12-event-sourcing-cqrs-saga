package com.smalaca.bankaccountmanagemnt.infrastructure.api.event.inmemory.bankaccount;

import com.smalaca.bankaccountmanagemnt.domain.bankaccount.event.BankAccountCreatedEvent;
import com.smalaca.bankaccountmanagemnt.domain.bankaccount.event.BankAccountEvent;
import com.smalaca.bankaccountmanagemnt.domain.bankaccount.event.MoneyDepositedEvent;
import com.smalaca.bankaccountmanagemnt.domain.bankaccount.event.MoneyWithdrawnEvent;
import com.smalaca.bankaccountview.BankAccountQueryListener;
import org.springframework.stereotype.Service;

@Service
public class BankAccountEventPublisher {
    private final BankAccountQueryListener bankAccountQueryListener;

    BankAccountEventPublisher(BankAccountQueryListener bankAccountQueryListener) {
        this.bankAccountQueryListener = bankAccountQueryListener;
    }

    public void listen(BankAccountEvent event) {
        if (event instanceof BankAccountCreatedEvent) {
            BankAccountCreatedExternalEvent externalEvent = BankAccountCreatedExternalEvent.create((BankAccountCreatedEvent) event);
            System.out.println(externalEvent);
            bankAccountQueryListener.listen(externalEvent);

        } else if (event instanceof MoneyDepositedEvent) {
            BankAccountModifiedExternalEvent externalEvent = BankAccountModifiedExternalEvent.create((MoneyDepositedEvent) event);
            System.out.println(externalEvent);
            bankAccountQueryListener.listen(externalEvent);

        } else if (event instanceof MoneyWithdrawnEvent) {
            BankAccountModifiedExternalEvent externalEvent = BankAccountModifiedExternalEvent.create((MoneyWithdrawnEvent) event);
            System.out.println(externalEvent);
            bankAccountQueryListener.listen(externalEvent);
        }
    }
}
