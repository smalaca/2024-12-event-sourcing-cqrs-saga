package com.smalaca.bankaccountmanagemnt.infrastructure.api.event.inmemory.bankaccount;

import com.smalaca.bankaccountmanagemnt.domain.bankaccount.event.BankAccountOpenedEvent;
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
        if (event instanceof BankAccountOpenedEvent) {
            BankAccountOpenedExternalEvent externalEvent = BankAccountOpenedExternalEvent.create((BankAccountOpenedEvent) event);
            System.out.println(externalEvent);
            bankAccountQueryListener.listen(externalEvent);

        } else if (event instanceof MoneyDepositedEvent) {
            TransactionMadeExternalEvent externalEvent = TransactionMadeExternalEvent.create((MoneyDepositedEvent) event);
            System.out.println(externalEvent);
            bankAccountQueryListener.listen(externalEvent);

        } else if (event instanceof MoneyWithdrawnEvent) {
            TransactionMadeExternalEvent externalEvent = TransactionMadeExternalEvent.create((MoneyWithdrawnEvent) event);
            System.out.println(externalEvent);
            bankAccountQueryListener.listen(externalEvent);
        }
    }
}
