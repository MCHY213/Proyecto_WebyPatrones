
package Proyecto_Web_Patrones.dao;

import Proyecto_Web_Patrones.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioDao extends JpaRepository<Usuario, Long> {    
    Usuario findByUsername(String username);
    
    //3 método agregados
    Usuario findByUsernameAndPassword(String username, String Password);//buscar un usuario y contraseña

    Usuario findByUsernameOrCorreo(String username, String correo);//busca usuario o correo

    boolean existsByUsernameOrCorreo(String username, String correo);//funcion booleana, valida si existe el usuario o correo, trate de buscar si existe o no.
}

    

