package com.smalaca.assortmentmanagement.domain.assortment.command;

import com.smalaca.assortmentmanagement.domain.commandid.CommandId;

import java.util.UUID;

public record SellProductCommand(CommandId commandId, UUID assortmentId, UUID productId, int quantity) {
}
