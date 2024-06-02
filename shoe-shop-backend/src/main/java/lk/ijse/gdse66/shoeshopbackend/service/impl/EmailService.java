package lk.ijse.gdse66.shoeshopbackend.service.impl;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

/**
 * @author : L.H.J
 * @File: EmailService
 * @mailto : lharshana2002@gmail.com
 * @created : 2024-06-01, Saturday
 **/

@Service
public class EmailService {
    @Autowired
    private JavaMailSender javaMailSender;

    public void sendHtmlEmail(String to, String subject, String htmlBody) {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper;
        try {
            helper = new MimeMessageHelper(message, true);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(htmlBody, true);
            javaMailSender.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
