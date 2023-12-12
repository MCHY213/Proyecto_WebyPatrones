
package Proyecto_Web_Patrones.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;

@Data   //Esta clase va a tener datos
@Entity
@Table(name="producto")
public class Producto implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column( name ="id_producto")
    private Long idProducto;
    //private Long idCategoria;
    private String descripcion;
    private String detalle;
    private double precio;
    private int existencias;
    private String rutaImagen;
    private boolean activo;
    
    @ManyToOne
    @JoinColumn (name="id_categoria")
    Categoria categoria;

}
