package com.ratel.test.controller;

import org.springframework.stereotype.Controller;

import java.util.Arrays;
import java.util.List;

@Controller
public class DemoController {

    //测试Arrays.asList操作
    public String testArraysAsList(){
        String[] myArray = { "Apple", "Banana", "Orange" };
        List<String> myList = Arrays.asList(myArray);
        myList.toArray();
        return "a";
    }
}
