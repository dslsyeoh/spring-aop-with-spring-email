package com.dsl.spring.aop.practice.aspect;

import com.dsl.spring.aop.practice.services.NotificationService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect
{
    @Autowired
    private NotificationService notificationService;

    @Around(value = "@annotation(logger)")
    public Object log(ProceedingJoinPoint proceedingJoinPoint, Logger logger) throws Throwable
    {
        System.out.println(logger.value());
        Object retVal = proceedingJoinPoint.proceed();
        System.out.println("after: " + retVal);
        notificationService.sendNotification();
        return retVal;
    }
}
