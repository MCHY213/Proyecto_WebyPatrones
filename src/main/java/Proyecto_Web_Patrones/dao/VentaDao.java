package Proyecto_Web_Patrones.dao;

import Proyecto_Web_Patrones.domain.Venta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VentaDao extends JpaRepository <Venta,Long> {
     
}
