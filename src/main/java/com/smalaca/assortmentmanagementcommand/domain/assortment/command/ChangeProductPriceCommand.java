package com.smalaca.assortmentmanagementcommand.domain.assortment.command;

import com.smalaca.sharedkernel.commandid.CommandId;

import java.util.UUID;

public record ChangeProductPriceCommand(CommandId commandId, UUID assortmentId, UUID productId, int price) {
}
