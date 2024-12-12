package com.smalaca.assortmentmanagementcommand.domain.assortment.command;

import com.smalaca.sharedkernel.commandid.CommandId;

import java.util.UUID;

public record SellProductCommand(CommandId commandId, UUID assortmentId, UUID productId, int quantity) {
}
