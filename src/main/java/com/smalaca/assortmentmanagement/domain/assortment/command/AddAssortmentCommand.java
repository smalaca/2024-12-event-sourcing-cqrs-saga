package com.smalaca.assortmentmanagement.domain.assortment.command;

import com.smalaca.assortmentmanagement.domain.commandid.CommandId;

import java.util.UUID;

public record AddAssortmentCommand(CommandId commandId, UUID sellerId, String name, String description) {
}
