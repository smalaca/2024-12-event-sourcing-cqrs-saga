package com.smalaca.transportpreparationsaga;

import com.smalaca.transportservice.OrderTransportCommand;
import com.smalaca.transportservice.TransportService;
import org.springframework.stereotype.Component;

@Component
class TransportServiceClient {
    private final TransportService transportService;

    TransportServiceClient(TransportService transportService) {
        this.transportService = transportService;
    }

    void publish(OrderTransportCommand command) {
        transportService.handle(command);
    }
}
