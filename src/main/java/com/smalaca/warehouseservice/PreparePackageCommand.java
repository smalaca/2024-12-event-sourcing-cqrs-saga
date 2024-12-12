package com.smalaca.warehouseservice;

import com.smalaca.sharedkernel.commandid.CommandId;

import java.util.UUID;

public record PreparePackageCommand(CommandId commandId, UUID productId, int quantity) {
}
