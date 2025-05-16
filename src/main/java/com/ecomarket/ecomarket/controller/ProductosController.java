package com.ecomarket.ecomarket.controller;

import com.ecomarket.ecomarket.model.Productos;
import com.ecomarket.ecomarket.service.ProductosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
@CrossOrigin(origins = "*")
public class ProductosController {

    @Autowired
    private ProductosService productosService;

    @GetMapping
    public List<Productos> obtenerProductos() {
        return productosService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Productos> obtenerPorId(@PathVariable int id) {
        return productosService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Productos crearProducto(@RequestBody Productos producto) {
        return productosService.guardar(producto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Productos> actualizarProducto(@PathVariable int id, @RequestBody Productos datosActualizados) {
        return productosService.obtenerPorId(id).map(p -> {
            p.setId_categoria(datosActualizados.getId_categoria());
            p.setNombre(datosActualizados.getNombre());
            p.setDescripcion(datosActualizados.getDescripcion());
            p.setSku(datosActualizados.getSku());
            p.setImagen(datosActualizados.getImagen());
            p.setPrecio(datosActualizados.getPrecio());
            p.setStock(datosActualizados.getStock());
            return ResponseEntity.ok(productosService.guardar(p));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarProducto(@PathVariable int id) {
        if (productosService.obtenerPorId(id).isPresent()) {
            productosService.eliminar(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
