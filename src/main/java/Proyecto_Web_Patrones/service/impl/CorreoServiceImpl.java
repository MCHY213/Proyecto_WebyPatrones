package Proyecto_Web_Patrones.service.impl;

import Proyecto_Web_Patrones.service.CorreoService;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class CorreoServiceImpl implements CorreoService {

    @Autowired
    private JavaMailSender mailSender;

    @Override
      public void enviarCorreoHtml( //envía el correo con parámetros, a quien va dirigido(correo), el asunto y el contenido en html.
              String para, 
              String asunto, 
              String contenidoHtml) 
              throws MessagingException {
          
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper 
                = new MimeMessageHelper(message, 
                        true);
        helper.setTo(para);
        helper.setSubject(asunto);
        helper.setText(contenidoHtml,true);
        mailSender.send(message);
    }
}
