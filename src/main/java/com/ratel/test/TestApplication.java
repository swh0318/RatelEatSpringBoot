package com.ratel.test;

import com.ratel.test.service.actuator.RatelEndPoint;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.autoconfigure.endpoint.condition.ConditionalOnEnabledEndpoint;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
public class TestApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestApplication.class, args);
    }

    @Configuration
    static class MyEndpointConfiguration{
        @Bean
        @ConditionalOnMissingBean
        @ConditionalOnEnabledEndpoint
        public RatelEndPoint myEndPoint(){
            return new RatelEndPoint();
        }
    }

}
