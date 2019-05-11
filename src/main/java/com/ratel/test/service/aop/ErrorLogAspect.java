package com.ratel.test.service.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect
@Component
public class ErrorLogAspect {

    @Pointcut("@annotation(ErrorLog)")
    public void annotationPointcut() {
    }

    /**
     * 前置通知
     * @param joinPoint
     */
    @Before("annotationPointcut()")
    public void beforePointcut(JoinPoint joinPoint) {
        MethodSignature methodSignature =  (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        ErrorLog annotation = method.getAnnotation(ErrorLog.class);
        String value = annotation.value();
        System.out.println("beforePointcut:"+value);
    }

    /**
     * 后置通知
     * @param joinPoint
     */
    @After("annotationPointcut()")
    public void afterPointcut(JoinPoint joinPoint) {
        MethodSignature methodSignature =  (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        ErrorLog annotation = method.getAnnotation(ErrorLog.class);
        String value = annotation.value();
        System.out.println("afterPointcut:"+value);
    }

    /**
     * aorund 环绕通知
     * @param joinPoint
     */
    @Around("annotationPointcut()")
    public void aroundPointCut(JoinPoint joinPoint){
        MethodSignature methodSignature =  (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        ErrorLog annotation = method.getAnnotation(ErrorLog.class);
        String value = annotation.value();
        System.out.println("aroundPointcut:"+value);
    }

    @AfterReturning("annotationPointcut()")
    public void afterReturning(JoinPoint joinPoint){
        MethodSignature methodSignature =  (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        ErrorLog annotation = method.getAnnotation(ErrorLog.class);
        String value = annotation.value();
        System.out.println("afterReturning:"+value);
    }

    @AfterThrowing("annotationPointcut()")
    public void afterThrowing(JoinPoint joinPoint){
        MethodSignature methodSignature =  (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        ErrorLog annotation = method.getAnnotation(ErrorLog.class);
        String value = annotation.value();
        System.out.println("发生异常:"+value);
    }



}
