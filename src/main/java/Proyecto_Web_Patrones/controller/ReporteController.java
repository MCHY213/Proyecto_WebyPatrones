
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
        Calendar fecha=Calendar.getInstance();
        String fechaIni=""+(fecha.get(Calendar.YEAR)-1)+"-01-01";
        String fechaIn=""+(fecha.get(Calendar.YEAR)-1)+"-01-01";//esta variable es de articulos para los paramentros de fechas, practica-5 y portafolio, semana 13
        
        String strMes=(fecha.get(Calendar.MONTH)<10?"0":"")+
                fecha.get(Calendar.MONTH);
        String strDia=(fecha.get(Calendar.DAY_OF_MONTH)<10?"0":"")+
                fecha.get(Calendar.DAY_OF_MONTH);
        String fechaFin=""+fecha.get(Calendar.YEAR)+"-"+strMes+"-"+strDia;
        String fechaFi=""+fecha.get(Calendar.YEAR)+"-"+strMes+"-"+strDia;//esta variable es de articulos para los paramentros de fechas, practica-5 y portafolio, semana 13
        
        model.addAttribute("fechaIni", fechaIni);
        model.addAttribute("fechaFin", fechaFin);
        //Articulos
        model.addAttribute("fechaIn", fechaIn);//esta variable es de articulos para los paramentros de fechas, practica-5 y portafolio, semana 13
        model.addAttribute("fechaFi", fechaFi);//esta variable es de articulos para los paramentros de fechas, practica-5 y portafolio, semana 13
        return "/reportes/principal";
    }

    @GetMapping("/usuarios")
    public ResponseEntity<Resource> reporteUsuarios(@RequestParam String tipo) 
            throws IOException {        
        var reporte = "usuarios";
        return reporteService.generaReporte(reporte, null, tipo);
    }

    
    @GetMapping("/ventas")// reportes de ventas
    public ResponseEntity<Resource> reporteVentas(@RequestParam String tipo) 
            throws IOException {
        var reporte="ventas";
        return reporteService.generaReporte(reporte, null, tipo);
    }
    
    @GetMapping("/Articulos")//Get mapping de Articulos, para mostrar la fecha con parámetros, fehaIn, fechaFi
    public ResponseEntity<Resource> reporteArticulos(
            @RequestParam String fechaIn,
            @RequestParam String fechaFi,
            @RequestParam String tipo) throws IOException {
        //Esto es para definir los paràmetros que se pasan al reporte cliente
        Map<String, Object> parametros = new HashMap();
        parametros.put("fechaIn", fechaIn);
        parametros.put("fechaFi", fechaFi);
        var reporte="Articulos";
        return reporteService.generaReporte(reporte, parametros, tipo);
    }
    
    @GetMapping("/Categorias")//agrego categorias como reporte
    public ResponseEntity<Resource> reporteCategorias(@RequestParam String tipo) 
            throws IOException {
        var reporte="Categorias";
        return reporteService.generaReporte(reporte, null, tipo);
    }

    @GetMapping("/ventasTotales")// reporte ventasTotales
    public ResponseEntity<Resource> reporteVentasTotales(
            @RequestParam String fechaInicio,
            @RequestParam String fechaFin,
            @RequestParam String tipo) throws IOException {
        //Esto es para definir los paràmetros que se pasan al reporte cliente
        Map<String, Object> parametros = new HashMap();
        parametros.put("fechaIni", fechaInicio);
        parametros.put("fechaFin", fechaFin);
        var reporte="ventasTotales";
        return reporteService.generaReporte(reporte, parametros, tipo);
    }
}