/*
 * Author Steven Yeoh
 * Copyright (c) 2019. All rights reserved
 */

package com.dsl.spring.aop.practice.services;

import com.dsl.spring.aop.practice.dto.MailSetup;

public interface NotificationService
{
    void sendEmail(MailSetup mailSetup);

    void sendEmailWithMessagePreparator(MailSetup mailSetup);

    void sendEmailWithAttachment(MailSetup mailSetup);
}
