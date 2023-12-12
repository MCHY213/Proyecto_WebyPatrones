
package Proyecto_Web_Patrones.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;
import lombok.Data;

@Data   //Esta clase va a tener datos
@Entity
@Table(name="rol")
public class Rol implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column( name ="id_rol")
    private Long idRol;
    private String nombre;
    @Column( name ="id_usuario")
    private Long idUsuario;

    
    
}
