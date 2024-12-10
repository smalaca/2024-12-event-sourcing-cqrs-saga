package com.smalaca.bankaccountmanagemnt.domain.bankaccount.command;

import com.smalaca.bankaccountmanagemnt.domain.commandid.CommandId;

import java.util.UUID;

public record CreateBankAccountCommand(CommandId commandId, UUID ownerId) {
}
