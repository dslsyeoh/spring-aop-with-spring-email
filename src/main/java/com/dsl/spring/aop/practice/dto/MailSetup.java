/*
 * Author Steven Yeoh
 * Copyright (c) 2019. All rights reserved
 */

package com.dsl.spring.aop.practice.dto;

import lombok.Data;

import java.net.URL;

@Data
public class MailSetup
{
    private String sender;
    private String receipt;
    private String subject;
    private String message;
    private URL attachmentPath;
    private String attachmentName;

    public MailSetup(String sender, String receipt, String subject)
    {
        this.sender = sender;
        this.receipt = receipt;
        this.subject = subject;
    }
}
