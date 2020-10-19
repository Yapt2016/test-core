package com.yapt.demo.test.core.web.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * 正常执行顺序 环绕通知开始->前置通知->环绕通知结束->后置通知->返回通知
 * 异常执行顺序 环绕通知开始->前置通知->环绕通知结束->后置通知->异常通知
 * @author hurui
 * @version Id: ServiceAspect.java, v 0.1 2020/6/16 17:08 YaphetS Exp $$
 */
@Slf4j
@Aspect
@Component
public class ServiceAspect {

    /**
     * 切入点
     * 1、execution(public * *(..)) 任意的公共方法
     * 2、execution（* set*（..）） 以set开头的所有的方法
     * 3、execution(* com.yapt.demo.test.core.service.login.UserServiceImpl.*(..)), UserServiceImpl类里的所有的方法
     * 4、execution(* com.yapt.demo.test.core.service.*.*(..)),service包下的所有的类的所有的方法
     * 5、execution(* com.yapt.demo.test.core.service..*.*(..)),service包下及子包下的所有的类的所有的方法
     * 7、@annotation(com.yapt.demo.test.core.service.api.annotation.MyAnnotation) 有特定注解的方法
     */
    @Pointcut("@annotation(com.yapt.demo.test.core.service.api.annotation.MyAnnotation)")
    public void pointCut(){
    }


    @Before("pointCut()")
    public void before(){
        log.info("*******************前置通知****************");
    }

    @After("pointCut()")
    public void after(){
        log.info("*******************后置通知****************");
    }

    @AfterReturning("pointCut()")
    public void afterRunning(){
        log.info("*******************返回通知****************");
    }

    @AfterThrowing("pointCut()")
    public void afterThrowing(){
        log.info("*******************异常通知****************");
    }

    @Around("pointCut()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        log.info("*******************环绕通知开始****************");
        Object obj = null;
        obj = pjp.proceed();
        log.info("*******************环绕通知结束****************");
        return obj;
    }
}