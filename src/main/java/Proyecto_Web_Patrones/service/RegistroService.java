package Proyecto_Web_Patrones.service;

import Proyecto_Web_Patrones.domain.Usuario;
import jakarta.mail.MessagingException;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

public interface RegistroService {

    public Model activar(Model model, String usuario, String clave); //activar un usuario y clave

    public Model crearUsuario(Model model, Usuario usuario) throws MessagingException; //crear el usuario
    
    public void activar(Usuario usuario, MultipartFile imagenFile); //usuario completo e imagen para activarlo
    
    public Model recordarUsuario(Model model, Usuario usuario) throws MessagingException; //parecido al crear un usuario, este recuerda
}