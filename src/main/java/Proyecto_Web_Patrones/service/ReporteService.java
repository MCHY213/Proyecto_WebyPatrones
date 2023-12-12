
package Proyecto_Web_Patrones.service;


import java.io.IOException;
import java.util.Map;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;

public interface ReporteService {
    
    //Se define la firma del método que genera los reportes, con los siguientes parámetros
    //1. reporte: es el nombre del archivo de reporte (.jasper)
    //2. parámetros: es un Map que contiene los parámetros del reporte... si los ocupa
    //3. tipo: si es el tipo de reporte: vPdf, Pdf, Xls, Csv
    
    public ResponseEntity<Resource> generaReporte(
    String reporte,
            Map<String, Object> parametros,
            String tipo)  throws IOException;
}
