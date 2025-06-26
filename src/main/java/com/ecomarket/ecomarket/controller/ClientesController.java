package com.ecomarket.ecomarket.controller;

import com.ecomarket.ecomarket.model.Clientes;
import com.ecomarket.ecomarket.service.ClientesService;
import com.ecomarket.ecomarket.assemblers.ClientesModelAssembler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@RestController
@RequestMapping("/api/clientes")
@CrossOrigin(origins = "*")
public class ClientesController {

    @Autowired
    private ClientesService clientesService;

    @Autowired
    private ClientesModelAssembler assembler;

    @GetMapping
    public CollectionModel<EntityModel<Clientes>> obtenerClientes() {
        List<EntityModel<Clientes>> clientes = clientesService.obtenerTodos().stream()
                .map(assembler::toModel)
                .collect(Collectors.toList());

        return CollectionModel.of(clientes,
                linkTo(methodOn(ClientesController.class).obtenerClientes()).withSelfRel());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntityModel<Clientes>> obtenerClientePorId(@PathVariable Long id) {
        Optional<Clientes> cliente = clientesService.buscarPorId(id);
        return cliente.map(c -> ResponseEntity.ok(assembler.toModel(c)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<EntityModel<Clientes>> crearCliente(@RequestBody Clientes cliente) {
        Clientes guardado = clientesService.guardarCliente(cliente);
        EntityModel<Clientes> modelo = assembler.toModel(guardado);
        return ResponseEntity
                .created(modelo.getRequiredLink(IanaLinkRelations.SELF).toUri())
                .body(modelo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EntityModel<Clientes>> actualizarCliente(@PathVariable Long id, @RequestBody Clientes datosActualizados) {
        Optional<Clientes> clienteOpt = clientesService.buscarPorId(id);
        if (clienteOpt.isPresent()) {
            Clientes cliente = clienteOpt.get();
            cliente.setNombre(datosActualizados.getNombre());
            cliente.setCorreoElectronico(datosActualizados.getCorreoElectronico());
            cliente.setTelefono(datosActualizados.getTelefono());
            cliente.setDireccion(datosActualizados.getDireccion());
            cliente.setFecha_registro(datosActualizados.getFecha_registro());

            Clientes actualizado = clientesService.guardarCliente(cliente);
            return ResponseEntity.ok(assembler.toModel(actualizado));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCliente(@PathVariable Long id) {
        Optional<Clientes> clienteOpt = clientesService.buscarPorId(id);
        if (clienteOpt.isPresent()) {
            clientesService.eliminarCliente(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}