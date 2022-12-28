package com.dev.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailServices {
    
    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String recipient;

    public String sendEmailText(String recipient, String title, String message) {
        
        try{
            SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
            simpleMailMessage.setFrom(recipient);
            simpleMailMessage.setTo(recipient);
            simpleMailMessage.setSubject(title);
            simpleMailMessage.setText(message);
            javaMailSender.send(simpleMailMessage);
            return "Email send";
        }  catch(Exception e) {
            return "ERROR to send Email";
        }  
    }
}
