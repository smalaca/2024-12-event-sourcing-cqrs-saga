package com.smalaca.bankaccountcommand.domain.bankaccount.command;

import com.smalaca.sharedkernel.commandid.CommandId;

import java.util.UUID;

public record CreateBankAccountCommand(CommandId commandId, UUID ownerId) {
}
