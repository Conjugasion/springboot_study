package com.example.springaopdemo.Aspect;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @author tangdongfan
 * @date 2020/5/13 17:16
 */
@Component
@Aspect
public class JoincutMethod {

    @Pointcut("@annotation(com.example.springaopdemo.Aspect.MyAopAnnotation)")
    public void JAnnotationPoint() {
        // System.out.println("Pointcut methods should have empty body ");
    }

    @Before("JAnnotationPoint()")
    public void execJAnnotation() throws Throwable {
        System.out.println("start");
    }

    /*@Around("JAnnotationPoint()")
    public Object execJAnnotation(ProceedingJoinPoint jp) throws Throwable {
        System.out.println("start");
        Object pd = jp.proceed();
        System.out.println("end");
        return jp;
    }*/

    /*@After("execution(* com.example.springaopdemo.Service..*.*(..))")
    public void execJAnnotation() throws Throwable {
        System.out.println("end");
    }*/
}
