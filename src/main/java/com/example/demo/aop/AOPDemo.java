package com.example.demo.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class AOPDemo {
    @Pointcut("execution(* com.example.demo.controller.HelloWorld.selectTest1(..))")
    private void pointCut() {}

    @Before("pointCut()")
    public void before(JoinPoint joinPoint) {
        log.debug("AOPDemo.before() start...");
        Object[] args = joinPoint.getArgs();
        log.debug("args are: {}", args);
        log.debug("AOPDemo.before() do something");
        log.debug("AOPDemo.before() end...");
    }

    @After("pointCut()")
    public void after(JoinPoint joinPoint) {
        log.debug("AOPDemo.after() start...");
        log.debug("AOPDemo.after() do something");
        log.debug("AOPDemo.after() end...");
    }

    // AfterReturning在After之前执行
    @AfterReturning(pointcut = "pointCut()", returning = "rtn")
    public void afterReturning(JoinPoint joinPoint, Object rtn) {
        log.debug("AOPDemo.afterReturning() start...");
        log.info("returning is: {}", rtn);
        log.debug("AOPDemo.afterReturning() do something");
        log.debug("AOPDemo.afterReturning() end...");
    }

    @AfterThrowing(pointcut = "pointCut()", throwing = "ex")
    public void afterThrowing(JoinPoint joinPoint, Exception ex) {
        log.debug("AOPDemo.afterThrowing() start...");
        log.error(ex.toString());
        log.debug("AOPDemo.afterThrowing() do something");
        log.debug("AOPDemo.afterThrowing() end...");
    }
}
