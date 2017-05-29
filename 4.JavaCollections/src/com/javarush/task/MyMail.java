package com.javarush.task;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;

/**
 * Created by Administrator on 26.05.2017.
 */
public class MyMail
{
    public static void main(String... args) throws MessagingException
        {
        Properties props = new Properties();
        props.put("mail.transport.protocol", "smtps");
        props.put("mail.smtps.host","smtp.gmail.com");
        props.put("mail.smtps.auth", "true");
        props.put("mail.smtp.sendpartial", "true");

        Session session = Session.getDefaultInstance(props);
        //создаем сообщение
        MimeMessage message = new MimeMessage(session);

//устанавливаем тему письма
        message.setSubject("тестовое письмо!");

//добавляем текст письма
        message.setText("Asta la vista, baby!");

//указываем получателя
        message.addRecipient( Message.RecipientType.TO, new InternetAddress ("stalone@gmail.com"));

//указываем дату отправления
        message.setSentDate(new Date ());
//логин и пароль gmail пользователя
        String userLogin = "arnold@gmail.com";
        String userPassword = "strong";

//авторизуемся на сервере:
        Transport transport = session.getTransport();
        transport.connect("smtp.gmail.com", 465, userLogin, userPassword);

//отправляем сообщение:
        transport.sendMessage(message, message.getRecipients(Message.RecipientType.TO));
        }
}
