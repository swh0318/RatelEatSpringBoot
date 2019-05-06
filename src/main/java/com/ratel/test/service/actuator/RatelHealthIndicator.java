package com.ratel.test.service.actuator;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component("Ratel_Health_Indicator")
public class RatelHealthIndicator implements HealthIndicator {
    private  static final String VERSION = "v1.0.0";

    @Override
    public Health health() {
        int code = 0;
        if(code != 0){
            Health.down().withDetail("code",code).withDetail("version",VERSION).build();
        }
        return Health.up().withDetail("code",code).withDetail("version",VERSION).up().build();
    }
}

