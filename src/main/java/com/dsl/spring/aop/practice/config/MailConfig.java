/*
 * Author Steven Yeoh
 * Copyright (c) 2019. All rights reserved
 */

package com.dsl.spring.aop.practice.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import java.util.Properties;

@Configuration
public class MailConfig
{
    @Value("${spring.mail.host}")
    private String host;

    @Value("${spring.mail.port}")
    private int port;

    @Value("${spring.mail.username}")
    private String username;

    @Value("${spring.mail.password}")
    private String password;

    @Value("${spring.mail.transport.protocol}")
    private String protocol;

    @Value("${spring.mail.smtp.auth}")
    private String isAuth;

    @Value("${spring.mail.smtp.starttls.enable}")
    private String isTTLS;

    @Value("${spring.mail.debug}")
    private String isDebug;

    @Bean
    public JavaMailSender mailSender()
    {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();

        mailSender.setHost(host);
        mailSender.setPort(port);
        mailSender.setUsername(username);
        mailSender.setPassword(password);

        Properties props = new Properties();
        props.put("mail.transport.protocol", protocol);
        props.put("mail.smtp.auth", isAuth);
        props.put("mail.smtp.starttls.enable", isTTLS);
        props.put("mail.debug", isDebug);

        mailSender.setJavaMailProperties(props);

        return mailSender;
    }
}
