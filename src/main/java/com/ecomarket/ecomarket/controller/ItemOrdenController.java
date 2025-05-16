package com.ecomarket.ecomarket.controller;

import com.ecomarket.ecomarket.model.ItemOrden;
import com.ecomarket.ecomarket.service.ItemOrdenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/itemordenes")
public class ItemOrdenController {

    @Autowired
    private ItemOrdenService itemOrdenService;

    @PostMapping
    public ResponseEntity<ItemOrden> crearItemOrden(@RequestBody ItemOrden itemOrden) {
        ItemOrden nuevoItem = itemOrdenService.guardarItemOrden(itemOrden);
        return ResponseEntity.ok(nuevoItem);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ItemOrden> obtenerItemOrdenPorId(@PathVariable Long id) {
        return itemOrdenService.obtenerItemOrdenPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public List<ItemOrden> listarTodosLosItemOrdenes() {
        return itemOrdenService.obtenerTodosLosItemOrdenes();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ItemOrden> actualizarItemOrden(@PathVariable Long id, @RequestBody ItemOrden itemOrden) {
        ItemOrden actualizado = itemOrdenService.actualizarItemOrden(id, itemOrden);
        if (actualizado != null) {
            return ResponseEntity.ok(actualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarItemOrden(@PathVariable Long id) {
        itemOrdenService.eliminarItemOrden(id);
        return ResponseEntity.noContent().build();
    }
}
