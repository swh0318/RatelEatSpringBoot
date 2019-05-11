package com.ratel.test.service.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Map;

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
        //获取参数
        Object[] objs = joinPoint.getArgs();
        System.out.println(String.valueOf(objs[0]));

        //--------------获取参数，有问题，todo-----------------
        /*Object obj=objs[0];
        Map<String ,Object> inMap= getParameter(obj);
        System.out.println(inMap);
        */
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

    @AfterReturning(value = "annotationPointcut() && args(a)", returning = "ret")
    public void afterReturning(JoinPoint joinPoint, Object ret, String a) {
        MethodSignature methodSignature =  (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        ErrorLog annotation = method.getAnnotation(ErrorLog.class);
        String value = annotation.value();
        System.out.println("afterReturning:" + value + ", parma:" + a + ", retun:" + ret);
    }

    @AfterThrowing("annotationPointcut()")
    public void afterThrowing(JoinPoint joinPoint){
        MethodSignature methodSignature =  (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        ErrorLog annotation = method.getAnnotation(ErrorLog.class);
        String value = annotation.value();
        System.out.println("发生异常:"+value);
    }

    /**
     * aorund 环绕通知
     *
     * @param //joinPoint
     */

    @Around("annotationPointcut()")
    public Object aroundPointCut(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        ErrorLog annotation = method.getAnnotation(ErrorLog.class);
        String value = annotation.value();
        System.out.println("aroundPointcut:" + value);
        Object object = joinPoint.proceed();
        System.out.println("aroundPointcut:" + value);
        return object;
    }

    //拓展日志的功能，对拦截的入参进行反射获取信息
    private Map<String, Object> getParameter(Object obj) {
        try {
            //反射对象中的属性
            Class clazz = obj.getClass();
            Field[] fields = clazz.getDeclaredFields();
            Map<String, Object> resultMap = new java.util.HashMap<>();
            //遍历并返回
            for (Field field : fields) {
                String fieldName = field.getName();
                PropertyDescriptor pd = new PropertyDescriptor(fieldName, clazz);
                Method readMethod = pd.getReadMethod();
                Object resultObj = readMethod.invoke(obj);
                resultMap.put(fieldName, resultObj);
            }
            return resultMap;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }



}
