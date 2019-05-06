package com.ratel.test.service.actuator;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;

import java.util.HashMap;
import java.util.Map;

@Endpoint(id = "ratelEndPoint")
public class RatelEndPoint {

    @ReadOperation
    public Map<String,String> test(){
        Map<String,String> result = new HashMap<>();
        result.put("name","ratel");
        result.put("age","18");
        return result;
    }

}

