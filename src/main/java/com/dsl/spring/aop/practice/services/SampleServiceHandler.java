package com.dsl.spring.aop.practice.services;

import com.dsl.spring.aop.practice.aspect.Logger;
import org.springframework.stereotype.Service;

@Service
public class SampleServiceHandler implements SampleService
{
    @Logger(value = "Log sample service call")
    @Override
    public String getValue()
    {
        return "Hello World!";
    }
}
