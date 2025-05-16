package com.ecomarket.ecomarket.controller;

import com.ecomarket.ecomarket.model.OrdenReposicion;
import com.ecomarket.ecomarket.service.OrdenReposicionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ordenes")
public class OrdenReposicionController {

    @Autowired
    private OrdenReposicionService ordenService;

    @PostMapping
    public ResponseEntity<OrdenReposicion> crearOrden(@RequestBody OrdenReposicion orden) {
        return ResponseEntity.ok(ordenService.guardarOrden(orden));
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrdenReposicion> obtenerPorId(@PathVariable String id) {
        return ordenService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public List<OrdenReposicion> listarTodas() {
        return ordenService.listarTodas();
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrdenReposicion> actualizarOrden(@PathVariable String id, @RequestBody OrdenReposicion orden) {
        OrdenReposicion actualizada = ordenService.actualizarOrden(id, orden);
        if (actualizada != null) {
            return ResponseEntity.ok(actualizada);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarOrden(@PathVariable String id) {
        ordenService.eliminarOrden(id);
        return ResponseEntity.noContent().build();
    }
}
