/*
 * Author Steven Yeoh
 * Copyright (c) 2019. All rights reserved
 */

package com.dsl.spring.aop.practice.services;

import com.dsl.spring.aop.practice.dto.MailSetup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.File;

import static javax.mail.Message.RecipientType.TO;

@Service
public class NotificationServiceHandler implements NotificationService
{
    @Autowired
    private JavaMailSender mailSender;

    @Override
    public void sendEmail(MailSetup mailSetup)
    {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom(mailSetup.getSender());
        simpleMailMessage.setTo(mailSetup.getReceipt());
        simpleMailMessage.setSubject(mailSetup.getSubject());
        simpleMailMessage.setText(mailSetup.getMessage());

        mailSender.send(simpleMailMessage);
    }

    @Override
    public void sendEmailWithMessagePreparator(MailSetup mailSetup)
    {
        MimeMessagePreparator mimeMessagePreparator = mimeMessage -> {
            mimeMessage.setSender(new InternetAddress(mailSetup.getSender()));
            mimeMessage.setRecipient(TO, new InternetAddress(mailSetup.getReceipt()));
            mimeMessage.setSubject(mailSetup.getSubject());
            mimeMessage.setText(mailSetup.getMessage());
        };
        mailSender.send(mimeMessagePreparator);
    }

    @Override
    public void sendEmailWithAttachment(MailSetup mailSetup)
    {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        try
        {
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
            helper.setFrom(mailSetup.getSender());
            helper.setTo(mailSetup.getReceipt());
            helper.setSubject(mailSetup.getSubject());
            helper.setText(mailSetup.getMessage());
            helper.addAttachment(mailSetup.getAttachmentName(), new File(mailSetup.getAttachmentPath().toURI()));

            mailSender.send(mimeMessage);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

}
