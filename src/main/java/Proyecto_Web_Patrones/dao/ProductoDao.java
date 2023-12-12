
package Proyecto_Web_Patrones.dao;

import Proyecto_Web_Patrones.domain.Producto;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoDao 
        extends JpaRepository<Producto, Long> {
    
    //Lista de productos utilizando un método Query
    public List<Producto>findByPrecioBetweenOrderByDescripcion(double precioInf, double precioSup);
}
