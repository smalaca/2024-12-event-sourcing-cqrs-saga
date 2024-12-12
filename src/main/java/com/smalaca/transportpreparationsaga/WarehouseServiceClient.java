package com.smalaca.transportpreparationsaga;

import com.smalaca.warehouseservice.PreparePackageCommand;
import com.smalaca.warehouseservice.WarehouseService;
import org.springframework.stereotype.Component;

@Component
class WarehouseServiceClient {
    private final WarehouseService warehouseService;

    WarehouseServiceClient(WarehouseService warehouseService) {
        this.warehouseService = warehouseService;
    }

    void publish(PreparePackageCommand command) {
        warehouseService.handle(command);
    }
}
