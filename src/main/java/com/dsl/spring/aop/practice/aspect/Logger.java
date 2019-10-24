package com.dsl.spring.aop.practice.aspect;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Logger
{
    String value();
}
