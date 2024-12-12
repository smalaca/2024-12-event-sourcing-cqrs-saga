package com.smalaca.bankaccountcommand.domain.bankaccount.command;

import com.smalaca.bankaccountcommand.domain.commandid.CommandId;

import java.util.UUID;

public record CreateBankAccountCommand(CommandId commandId, UUID ownerId) {
}
