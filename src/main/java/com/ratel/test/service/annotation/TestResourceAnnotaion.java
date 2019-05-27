package com.ratel.test.service.annotation;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestResourceAnnotaion {

    private static Double randomNum = Math.random();

    public Double getRandomNum() {
        return randomNum;
    }
}
