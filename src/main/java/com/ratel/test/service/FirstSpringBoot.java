package com.ratel.test.service;


import com.ratel.test.knowledge.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "firstSpringBoot")
@EnableAutoConfiguration
public class FirstSpringBoot {

    @Autowired
    Person person;

    /**
     * 测试映射注解
     * @return
     */
    @GetMapping
    @RequestMapping(value = "mappingTest")
    public String mappingTest(){
        return "老板，您的第一个Spring Boot项目洽谈成功！！！";
    }

    /**
     * 测试bean
     * @return
     */
    @GetMapping
    @RequestMapping(value = "beantest")
    public String beanTest(){
        return "姓名："+ person.getName() + "年龄："+ person.getAge();
    }



}
