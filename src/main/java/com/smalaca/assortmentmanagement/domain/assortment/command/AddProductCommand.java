package com.smalaca.assortmentmanagement.domain.assortment.command;

import com.smalaca.assortmentmanagement.domain.commandid.CommandId;

import java.util.UUID;

public record AddProductCommand(CommandId commandId, UUID assortmentId, String productIdentifier, String name, int price, int quantity) {
}
