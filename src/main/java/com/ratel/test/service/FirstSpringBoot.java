package com.ratel.test.service;


import com.ratel.test.knowledge.Person;
import com.ratel.test.service.annotation.EmployeeInfo;
import com.ratel.test.service.annotation.EmployeeInfoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping(value = "test")
@EnableAutoConfiguration
public class FirstSpringBoot {

    @Autowired
    Person person;

    /**
     * 测试映射注解
     * @return
     */
    @GetMapping
    @RequestMapping(value = "mapping")
    public String mappingTest(){
        return "老板，您的第一个Spring Boot项目洽谈成功！！！";
    }

    /**
     * 测试bean
     * @return
     */
    @GetMapping
    @RequestMapping(value = "bean")
    public String beanTest(){
        return "姓名："+ person.getName() + "年龄："+ person.getAge();
    }

    @RequestMapping("runtimeAnnotation")
    public Map getAnnotationInfos() {
        return EmployeeInfoUtil.getEmployeeInfo(EmployeeInfo.class);
    }



}
