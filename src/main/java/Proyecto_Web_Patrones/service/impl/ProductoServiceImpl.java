
package Proyecto_Web_Patrones.service.impl;

import Proyecto_Web_Patrones.dao.ProductoDao;
import Proyecto_Web_Patrones.domain.Producto;
import Proyecto_Web_Patrones.service.ProductoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductoServiceImpl implements ProductoService{

    @Autowired 
    private ProductoDao productoDao;
    
    @Override
    public List<Producto> getProductos(boolean activo) {
        var productos = productoDao.findAll();
        if (activo) {
            productos.removeIf(e -> !e.isActivo());
        }
        return productos;
    }
    @Override
    @Transactional(readOnly = true)
    public Producto getProducto(Producto producto) {
        return productoDao.findById(producto.getIdProducto()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Producto producto) {
        productoDao.save(producto);
    }

    @Override
    @Transactional
    public void delete(Producto producto) {
        productoDao.delete(producto);
    }
    //Lista de productos utilizando un método Query
    @Override
    @Transactional(readOnly=true)
    public List<Producto>consultaQuery(double precioInf, double precioSup){
        return productoDao.findByPrecioBetweenOrderByDescripcion(precioInf, precioSup);
    }
}
