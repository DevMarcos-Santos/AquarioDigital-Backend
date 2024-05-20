package com.project.peixelandia.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    public String envioEmail(String destinatario, String titulo, String mensagem){
        try{
            SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
            simpleMailMessage.setFrom("aquariodigitaloficial@gmail.com");
            simpleMailMessage.setTo(destinatario);
            simpleMailMessage.setSubject(titulo);
            simpleMailMessage.setText(mensagem);
            javaMailSender.send(simpleMailMessage);
            return "Email enviado com sucesso!";
        }catch (Exception e){
            return "Problema no envio do email!";
        }

    }
}
