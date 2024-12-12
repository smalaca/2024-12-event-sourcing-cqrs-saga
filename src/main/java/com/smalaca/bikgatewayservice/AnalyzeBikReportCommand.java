package com.smalaca.bikgatewayservice;

import com.smalaca.sharedkernel.commandid.CommandId;

import java.util.UUID;

public record AnalyzeBikReportCommand(CommandId commandId, UUID accountDebtSagaId, UUID bankAccountId, UUID ownerId) {
}
