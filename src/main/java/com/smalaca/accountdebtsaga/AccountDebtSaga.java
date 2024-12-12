package com.smalaca.accountdebtsaga;

import com.smalaca.bankaccountcommand.infrastructure.api.event.inmemory.bankaccount.NotEnoughMoneyRecognizedPivotalEvent;
import com.smalaca.bankaccounthistoryservice.AnalyzeBankAccountCommand;
import com.smalaca.bankaccounthistoryservice.BankAccountHistoryNotFoundEvent;
import com.smalaca.bikgatewayservice.AnalyzeBikReportCommand;
import com.smalaca.bikgatewayservice.BikReportNotFoundEvent;
import com.smalaca.sharedkernel.commandid.CommandId;

import java.util.UUID;

public class AccountDebtSaga {
    private UUID sagaId;
    private UUID ownerId;
    private UUID bankAccountId;

    private Boolean bikAnalysisRequested;
    private Boolean bankAccountAnalysisRequested;
    private Boolean bikReportFound;
    private Boolean bankAccountHistoryFound;

    AccountDebtSaga(UUID sagaId) {
        this.sagaId = sagaId;
    }

    UUID getSagaId() {
        return sagaId;
    }

    void listen(NotEnoughMoneyRecognizedPivotalEvent event, BikClient bikClient, BankAccountHistoryClient bankAccountHistoryClient) {
        bikClient.publish(analyzeBikReportCommand(event));
        bankAccountHistoryClient.publish(analyzeBankAccountCommand(event));
        bankAccountId = event.bankAccountId();
        ownerId = event.ownerId();
        bikAnalysisRequested = true;
        bankAccountAnalysisRequested = true;
    }

    private AnalyzeBikReportCommand analyzeBikReportCommand(NotEnoughMoneyRecognizedPivotalEvent event) {
        return new AnalyzeBikReportCommand(CommandId.next(event.eventId()), sagaId, bankAccountId, ownerId);
    }

    private AnalyzeBankAccountCommand analyzeBankAccountCommand(NotEnoughMoneyRecognizedPivotalEvent event) {
        return new AnalyzeBankAccountCommand(CommandId.next(event.eventId()), sagaId, bankAccountId, ownerId);
    }

    void listen(BikReportNotFoundEvent event) {
        bikReportFound = false;
    }

    void listen(BankAccountHistoryNotFoundEvent event) {
        bankAccountHistoryFound = false;
    }

    boolean isCompleted() {
        return !bikReportFound && !bankAccountHistoryFound;
    }
}
