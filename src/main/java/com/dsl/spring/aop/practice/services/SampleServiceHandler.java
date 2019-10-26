/*
 * Author Steven Yeoh
 * Copyright (c) 2019. All rights reserved
 */

package com.dsl.spring.aop.practice.services;

import com.dsl.spring.aop.practice.aspect.Notify;
import org.springframework.stereotype.Service;

@Service
public class SampleServiceHandler implements SampleService
{
    @Notify(type = "simple")
    @Override
    public String sample()
    {
        return "Send simple email message";
    }

    @Notify(type = "preparator")
    @Override
    public String sample2()
    {
        return "Send email with preparator";
    }

    @Notify(type = "attachment")
    @Override
    public String sample3()
    {
        return "Send email with attachment";
    }
}
