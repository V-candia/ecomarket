package com.ecomarket.ecomarket.controller;

import com.ecomarket.ecomarket.model.Clientes;
import com.ecomarket.ecomarket.repository.ClientesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/clientes")
@CrossOrigin(origins = "*") // Permite llamadas desde el frontend si estás usando uno
public class ClientesController {

    @Autowired
    private ClientesRepository clientesRepository;

    // Obtener todos los clientes
    @GetMapping
    public List<Clientes> obtenerClientes() {
        return clientesRepository.findAll();
    }

    // Obtener un cliente por ID
    @GetMapping("/{id}")
    public ResponseEntity<Clientes> obtenerClientePorId(@PathVariable Long id) {
        Optional<Clientes> cliente = clientesRepository.findById(id);
        return cliente.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Crear un nuevo cliente
    @PostMapping
    public Clientes crearCliente(@RequestBody Clientes cliente) {
        return clientesRepository.save(cliente);
    }

    // Actualizar un cliente existente
    @PutMapping("/{id}")
    public ResponseEntity<Clientes> actualizarCliente(@PathVariable Long id, @RequestBody Clientes datosActualizados) {
        return clientesRepository.findById(id).map(cliente -> {
            cliente.setNombre(datosActualizados.getNombre());
            cliente.setCorreoElectronico(datosActualizados.getCorreoElectronico());
            cliente.setTelefono(datosActualizados.getTelefono());
            cliente.setDireccion(datosActualizados.getDireccion());
            cliente.setFecha_registro(datosActualizados.getFecha_registro());
            return ResponseEntity.ok(clientesRepository.save(cliente));
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Eliminar un cliente
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCliente(@PathVariable Long id) {
        if (clientesRepository.existsById(id)) {
            clientesRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
