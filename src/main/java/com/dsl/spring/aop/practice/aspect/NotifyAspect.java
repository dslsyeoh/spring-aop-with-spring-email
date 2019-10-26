/*
 * Author Steven Yeoh
 * Copyright (c) 2019. All rights reserved
 */

package com.dsl.spring.aop.practice.aspect;

import com.dsl.spring.aop.practice.dto.MailSetup;
import com.dsl.spring.aop.practice.services.NotificationService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.URL;

@Component
@Aspect
public class NotifyAspect
{
    @Autowired
    private NotificationService notificationService;

    @Around(value = "@annotation(notify)")
    public Object notify(ProceedingJoinPoint proceedingJoinPoint, Notify notify) throws Throwable
    {
        Object retVal = proceedingJoinPoint.proceed();
        MailSetup mailSetup = new MailSetup("sender@mail.com", "receipt@mail.com", "<subject>");
        switch (notify.type())
        {
            case "simple":
                mailSetup.setMessage("<content>");
                notificationService.sendEmail(mailSetup);
                break;
            case "preparator":
                mailSetup.setMessage("<content>");
                notificationService.sendEmailWithMessagePreparator(mailSetup);
                break;
            case "attachment":
                mailSetup.setMessage("<content>");
                mailSetup.setAttachmentName("<attachment_name>");
                mailSetup.setAttachmentPath(new URL("<attachment_path>"));
                notificationService.sendEmailWithAttachment(mailSetup);
                break;
        }
        return retVal;
    }
}
