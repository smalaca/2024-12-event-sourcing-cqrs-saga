package com.smalaca.accountdebtsaga;

import com.smalaca.bikgatewayservice.AnalyzeBikReportCommand;
import com.smalaca.bikgatewayservice.BikService;
import org.springframework.stereotype.Component;

@Component
class BikClient {
    private final BikService bikService;

    BikClient(BikService bikService) {
        this.bikService = bikService;
    }

    void publish(AnalyzeBikReportCommand command) {
        bikService.handle(command);
    }
}
