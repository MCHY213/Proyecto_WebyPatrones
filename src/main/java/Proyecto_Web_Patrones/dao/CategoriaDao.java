
package Proyecto_Web_Patrones.dao;

import Proyecto_Web_Patrones.domain.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaDao extends JpaRepository<Categoria, Long> {
    
    
}
