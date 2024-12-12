package com.smalaca.bankaccountcommand.domain.bankaccount.command;

import com.smalaca.sharedkernel.commandid.CommandId;

import java.util.UUID;

public record WithdrawMoneyCommand(CommandId commandId, UUID bankAccountId, int withdrawal) {
}
