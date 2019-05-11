package com.ratel.test.service;

import com.ratel.test.knowledge.Person;
import com.ratel.test.service.annotation.EmployeeInfo;
import com.ratel.test.service.annotation.EmployeeInfoUtil;
import com.ratel.test.service.aop.ErrorLog;
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

    /**
     * 编译时注解，暂未编译成功
     */
    @RequestMapping("compileAnnotation")
    public void compileAnnotation(){
        System.out.println("step into compileAnnotation");
    }

    /**
     * 切面编程注解实例测试
     */
    @RequestMapping("aspectAnnotation")
    @ErrorLog("errorlog_value")
    public String aspectAnnotation(String name) {
        System.out.println("step into aspectAnnotation");
        return "request successfully";
    }

    public String apectjAnnotation(String param) {
        return param;
    }


}
