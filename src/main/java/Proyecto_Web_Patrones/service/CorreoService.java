package Proyecto_Web_Patrones.service;

import jakarta.mail.MessagingException;

public interface CorreoService {
    public void enviarCorreoHtml(
            String para, 
            String asunto, 
            String contenidoHtml) 
            throws MessagingException;
}