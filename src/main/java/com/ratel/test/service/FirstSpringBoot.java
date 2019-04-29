package com.ratel.test.service;


import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "testabc")
@EnableAutoConfiguration
public class FirstSpringBoot {
    @RequestMapping(value = "test", method = RequestMethod.GET)
    public String test(){
        return "abc";
    }

}
