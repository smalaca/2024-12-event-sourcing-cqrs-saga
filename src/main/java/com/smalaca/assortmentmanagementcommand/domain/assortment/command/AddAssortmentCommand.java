package com.smalaca.assortmentmanagementcommand.domain.assortment.command;

import com.smalaca.sharedkernel.commandid.CommandId;

import java.util.UUID;

public record AddAssortmentCommand(CommandId commandId, UUID sellerId, String name, String description) {
}
