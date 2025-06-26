package com.ecomarket.ecomarket.ControllerTest;

import com.ecomarket.ecomarket.controller.ClientesController;
import com.ecomarket.ecomarket.model.Clientes;
import com.ecomarket.ecomarket.service.ClientesService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.doNothing;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ClientesController.class)
public class ClientesControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ClientesService clientesService;

    @MockBean
    private com.ecomarket.ecomarket.assemblers.ClientesModelAssembler clientesModelAssembler;

    @Autowired
    private ObjectMapper objectMapper;

    // Datos de prueba (ajustados al model real)
    Clientes cliente = new Clientes(1L, "Juan", "juan@mail.com", "123456789", "Calle Falsa 123", LocalDate.now());

    @Test
    @DisplayName("GET /api/clientes retorna lista de clientes")
    void obtenerTodos() throws Exception {
        when(clientesService.obtenerTodos()).thenReturn(List.of(cliente));
        when(clientesModelAssembler.toModel(cliente))
                .thenReturn(EntityModel.of(cliente));
        CollectionModel<EntityModel<Clientes>> collectionModel = CollectionModel.of(List.of(EntityModel.of(cliente)));

        when(clientesModelAssembler.toCollectionModel(List.of(cliente)))
                .thenReturn(collectionModel);

        mockMvc.perform(get("/api/clientes"))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("GET /api/clientes/{id} retorna un cliente existente")
    void obtenerPorId_existente() throws Exception {
        when(clientesService.buscarPorId(1L)).thenReturn(Optional.of(cliente));
        when(clientesModelAssembler.toModel(cliente))
                .thenReturn(EntityModel.of(cliente));

        mockMvc.perform(get("/api/clientes/1"))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("GET /api/clientes/{id} retorna 404 si no existe")
    void obtenerPorId_noExistente() throws Exception {
        when(clientesService.buscarPorId(100L)).thenReturn(Optional.empty());
        mockMvc.perform(get("/api/clientes/100"))
                .andExpect(status().isNotFound());
    }

    @Test
    @DisplayName("POST /api/clientes crea un nuevo cliente")
    void crearCliente() throws Exception {
        Clientes nuevo = new Clientes(null, "Ana", "ana@mail.com", "383838383", "Otra calle", LocalDate.now());
        Clientes guardado = new Clientes(2L, "Ana", "ana@mail.com", "383838383", "Otra calle", LocalDate.now());

        when(clientesService.guardarCliente(any(Clientes.class))).thenReturn(guardado);

        // Añadir link "self"
        EntityModel<Clientes> entityModelConLink = EntityModel.of(
                guardado,
                Link.of("http://localhost/api/clientes/2").withSelfRel()
        );
        when(clientesModelAssembler.toModel(guardado)).thenReturn(entityModelConLink);

        mockMvc.perform(post("/api/clientes")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(nuevo)))
                .andExpect(status().isCreated());
    }

    @Test
    @DisplayName("PUT /api/clientes/{id} actualiza un cliente existente")
    void actualizarCliente_existente() throws Exception {
        Clientes actualizado = new Clientes(1L, "Juan Actual", "juan@mail.com", "0000", "Nueva Dir", LocalDate.now());

        when(clientesService.buscarPorId(1L)).thenReturn(Optional.of(cliente));
        when(clientesService.guardarCliente(any(Clientes.class))).thenReturn(actualizado);
        when(clientesModelAssembler.toModel(actualizado))
                .thenReturn(EntityModel.of(actualizado));

        mockMvc.perform(put("/api/clientes/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(actualizado)))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("PUT /api/clientes/{id} cliente no existe -> 404")
    void actualizarCliente_noExistente() throws Exception {
        Clientes actualizado = new Clientes(99L, "NoExiste", "no@existe.com", "0000", "x", LocalDate.now());

        when(clientesService.buscarPorId(99L)).thenReturn(Optional.empty());

        mockMvc.perform(put("/api/clientes/99")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(actualizado)))
                .andExpect(status().isNotFound());
    }

    @Test
    @DisplayName("DELETE /api/clientes/{id} elimina cliente")
    void eliminarCliente_existente() throws Exception {
        when(clientesService.buscarPorId(1L)).thenReturn(Optional.of(cliente));
        doNothing().when(clientesService).eliminarCliente(1L);

        mockMvc.perform(delete("/api/clientes/1"))
                .andExpect(status().isNoContent());
    }

    @Test
    @DisplayName("DELETE /api/clientes/{id} 404 si no existe")
    void eliminarCliente_noExistente() throws Exception {
        when(clientesService.buscarPorId(100L)).thenReturn(Optional.empty());

        mockMvc.perform(delete("/api/clientes/100"))
                .andExpect(status().isNotFound());
    }
}