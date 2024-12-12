package com.smalaca.transportservice;

import com.smalaca.sharedkernel.commandid.CommandId;

import java.util.UUID;

public record OrderTransportCommand(CommandId commandId, UUID productId, int quantity) {
}
