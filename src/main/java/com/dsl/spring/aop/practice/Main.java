/*
 * Author Steven Yeoh
 * Copyright (c) 2019. All rights reserved
 */

package com.dsl.spring.aop.practice;

import com.dsl.spring.aop.practice.services.SampleService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Main
{
    public static void main(String[] args)
    {
        ConfigurableApplicationContext context = SpringApplication.run(Main.class);
        SampleService sampleService = context.getBean(SampleService.class);
        System.out.println(sampleService.sample());
        System.out.println(sampleService.sample2());
        System.out.println(sampleService.sample3());
    }
}
