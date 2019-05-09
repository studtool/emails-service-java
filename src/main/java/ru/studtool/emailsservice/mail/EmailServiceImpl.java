package ru.studtool.emailsservice.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {

    private final JavaMailSender emailSender;

    @Autowired
    public EmailServiceImpl(JavaMailSender emailSender) {
        this.emailSender = emailSender;
    }

    public void sendRegistrationEmail(String email) {
        var message = new SimpleMailMessage();
        message.setTo(email);
        message.setSubject("Registration");
        message.setText("Welcome to studtool!");
        emailSender.send(message);
    }
}
