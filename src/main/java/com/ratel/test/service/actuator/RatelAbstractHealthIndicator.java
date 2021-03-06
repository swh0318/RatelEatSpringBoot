package com.ratel.test.service.actuator;

import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health;
import org.springframework.stereotype.Component;

/**
 * 功能更强大，AbstractHealthIndicator实现了HealthIndicator接口
 */
@Component("Ratel_Abstract_Health_Indicator")
public class RatelAbstractHealthIndicator extends AbstractHealthIndicator {
    private static final String VERSION = "v1.0.1";
    @Override
    protected void doHealthCheck(Health.Builder builder) throws Exception {
        int code = 0;
        if(code != 0){
            builder.down().withDetail("code",code).withDetail("version",VERSION).build();
        }
        builder.withDetail("code",code).withDetail("version",VERSION).up().build();
    }
}


