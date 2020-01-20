package com.bfs.backend.service.impl;
import com.bfs.backend.domain.EmailTemplate;
import com.bfs.backend.service.SendEmailService;
import org.springframework.stereotype.Service;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

@Service
public class SendEmailServiceImpl implements SendEmailService {
    private final String sender = "testing1975cuicui@gmail.com";
    private final String password = "testingtesting";
    private final String host = "smtp.gmail.com";

    public void sendEmailTemplate(EmailTemplate emailTemplate, String receiver, String FirstName){
        Properties properties = new Properties();
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.ssl.trust", "*");
        properties.put("mail.smtp.socketFactory.port", "465");
        properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        properties.put("mail.smtp.socketFactory.fallback", "false");
        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(sender, password);
            }
        });
        try{
            MimeMessage mimeMessage =new MimeMessage(session);
            mimeMessage.setFrom(new InternetAddress(sender));
            mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(receiver));
            mimeMessage.setSubject(emailTemplate.getEmailSubject());
            mimeMessage.setText(emailTemplate.getEmailTemplateContent().replace("xxxxx",FirstName));
            Transport.send(mimeMessage);
            System.out.println("Printing successfully .....");
        } catch (Exception e){
            System.out.print("Couldn't send email");
            e.printStackTrace();
        }
    }

}
