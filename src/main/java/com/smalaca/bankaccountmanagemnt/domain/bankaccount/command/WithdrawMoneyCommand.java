package com.smalaca.bankaccountmanagemnt.domain.bankaccount.command;

import com.smalaca.bankaccountmanagemnt.domain.commandid.CommandId;

import java.util.UUID;

public record WithdrawMoneyCommand(CommandId commandId, UUID bankAccountId, int withdrawal) {
}
