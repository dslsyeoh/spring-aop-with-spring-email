package com.dsl.spring.aop.practice.services;

import org.springframework.stereotype.Service;

@Service
public class NotificationServiceHandler implements NotificationService
{
    @Override
    public void sendNotification()
    {
        System.out.println("Send notification to user");
    }
}
