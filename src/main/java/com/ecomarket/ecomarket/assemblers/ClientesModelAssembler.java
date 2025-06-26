package com.ecomarket.ecomarket.assemblers;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import com.ecomarket.ecomarket.controller.ClientesController;
import com.ecomarket.ecomarket.model.Clientes;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

@Component
public class ClientesModelAssembler implements RepresentationModelAssembler<Clientes, EntityModel<Clientes>> {

    @Override
    public EntityModel<Clientes> toModel(Clientes cliente) {
        return EntityModel.of(cliente,
                linkTo(methodOn(ClientesController.class).obtenerClientePorId(cliente.getId())).withSelfRel(),
                linkTo(methodOn(ClientesController.class).obtenerClientes()).withRel("clientes"));
    }
}
