package com.jt.framework.Aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Aspect

public class AopAdvice {

    @Around("execution(* com.jt.ssalMuck.*.Controller..*(..))")
    public Object doTransaction(ProceedingJoinPoint joinPoint) throws Throwable {


        Object rtnObj = joinPoint.proceed();

        log.info("Aop-------------------------------");
        log.info("-------------------------------");
        log.info("-------------------------------");
        log.info("-------------------------------");
        log.info("-------------------------------");
        log.info("-------------------------------");

        return rtnObj;
    }

}
