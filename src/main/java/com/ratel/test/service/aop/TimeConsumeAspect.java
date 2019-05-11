package com.ratel.test.service.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

//通过表达式匹配方法
@Aspect
@Component
public class TimeConsumeAspect {
    // 第一个*代表返回类型不限
    // 第二个*代表所有类
    // 第三个*代表所有方法
    // (..) 代表参数不限
    @Pointcut("execution(public * com.ratel.test.service.*.*(..))")
    @Order(2)
    public void pointCut() {
    }

    ;

    @Pointcut("@annotation(ErrorLog)")
    @Order(1) // Order 代表优先级，数字越小优先级越高
    public void annoationPoint() {
    }

    ;

    @Before(value = "annoationPoint() || pointCut()")
    public void around(JoinPoint pjp) throws Throwable {

    }

    private void before() {
        System.out.println("Before");
    }

    private void after() {
        System.out.println("After");
    }


}
