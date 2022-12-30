package com.dev.backend.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import freemarker.template.Configuration;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class EmailServices {
    
    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private Configuration fmConfiguration;

    @Value("${spring.mail.username}")
    private String sender;

    public String sendEmailText(String recipient, String title, String message) {
        
        try{
            SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
            simpleMailMessage.setFrom(sender);
            simpleMailMessage.setTo(recipient);
            simpleMailMessage.setSubject(title);
            simpleMailMessage.setText(message);
            javaMailSender.send(simpleMailMessage);
            return "Email send";
        }catch(Exception e) {
            return "ERROR to send Email";
        }  
    }

    public void send(String recipient, String title, Map<String, Object> properties) {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        try{
            MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, true);
            messageHelper.setSubject("title");
            messageHelper.setFrom(sender);
            messageHelper.setTo(recipient);
            messageHelper.setText(getTemplateContent(properties), true);
            javaMailSender.send(messageHelper.getMimeMessage());
        }catch(MessagingException e) {
            e.printStackTrace();
        }
    }

    public String getTemplateContent(Map<String, Object> model) {
        StringBuffer content = new StringBuffer();
        try {
            content.append(FreeMarkerTemplateUtils.processTemplateIntoString(fmConfiguration.getTemplate("email-code-recovery.flth"), model));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return content.toString();
    }
}
