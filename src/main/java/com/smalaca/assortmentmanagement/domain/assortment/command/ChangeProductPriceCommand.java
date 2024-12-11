package com.smalaca.assortmentmanagement.domain.assortment.command;

import com.smalaca.assortmentmanagement.domain.commandid.CommandId;

import java.util.UUID;

public record ChangeProductPriceCommand(CommandId commandId, UUID assortmentId, UUID productId, int price) {
}
