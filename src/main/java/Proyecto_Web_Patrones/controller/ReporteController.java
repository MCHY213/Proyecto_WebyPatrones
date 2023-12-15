
package Proyecto_Web_Patrones.controller;

import Proyecto_Web_Patrones.service.ReporteService;
import java.io.IOException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/reportes")
public class ReporteController {

    @Autowired
    ReporteService reporteService;
    
    @GetMapping("/principal")
    public String principal(Model model) {
        
        return "/reportes/principal";
    }
    
    @GetMapping("/kejiArticulos")//agrego kejiArticulos como reporte
    public ResponseEntity<Resource> reportekejiArticulos(@RequestParam String tipo) 
            throws IOException {
        var reporte="kejiArticulos";
        return reporteService.generaReporte(reporte, null, tipo);
    
}

    @GetMapping("/kejiUsuarios")
    public ResponseEntity<Resource> reportekejiUsuarios(@RequestParam String tipo) 
            throws IOException {        
        var reporte = "kejiUsuarios";
        return reporteService.generaReporte(reporte, null, tipo);
    }
   
}