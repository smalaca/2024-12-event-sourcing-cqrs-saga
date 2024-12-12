package com.smalaca.bankaccounthistoryservice;

import com.smalaca.sharedkernel.commandid.CommandId;

import java.util.UUID;

public record AnalyzeBankAccountCommand(CommandId commandId, UUID accountDebtSagaId, UUID bankAccountId, UUID ownerId) {
}
