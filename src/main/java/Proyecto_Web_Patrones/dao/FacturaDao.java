package Proyecto_Web_Patrones.dao;

import Proyecto_Web_Patrones.domain.Factura;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacturaDao extends JpaRepository <Factura,Long> {
     
}
