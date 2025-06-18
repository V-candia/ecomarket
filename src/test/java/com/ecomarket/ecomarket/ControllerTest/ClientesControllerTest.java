package com.ecomarket.ecomarket.ControllerTest;

import com.ecomarket.ecomarket.controller.ClientesController;
import com.ecomarket.ecomarket.model.Clientes;
import com.ecomarket.ecomarket.repository.ClientesRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ClientesController.class)
public class ClientesControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ClientesRepository clientesRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void obtenerClientes_debeRetornarLista() throws Exception {
        Clientes cliente = new Clientes(1L, "Juan", "juan@mail.com", "123456789", "Calle Falsa 123", LocalDate.now());

        when(clientesRepository.findAll()).thenReturn(Arrays.asList(cliente));

        mockMvc.perform(get("/api/clientes"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].nombre").value("Juan"));
    }

    @Test
    void obtenerClientePorId_existente() throws Exception {
        Clientes cliente = new Clientes(1L, "Juan", "juan@mail.com", "123456789", "Calle Falsa 123", LocalDate.now());

        when(clientesRepository.findById(1L)).thenReturn(Optional.of(cliente));

        mockMvc.perform(get("/api/clientes/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nombre").value("Juan"));
    }

    @Test
    void obtenerClientePorId_noExistente() throws Exception {
        when(clientesRepository.findById(1L)).thenReturn(Optional.empty());

        mockMvc.perform(get("/api/clientes/1"))
                .andExpect(status().isNotFound());
    }

    @Test
    void crearCliente() throws Exception {
        Clientes cliente = new Clientes(null, "Ana", "ana@mail.com", "987654321", "Av Siempre Viva", LocalDate.now());

        when(clientesRepository.save(any(Clientes.class)))
                .thenAnswer(invocation -> {
                    Clientes saved = invocation.getArgument(0);
                    saved.setId(1L);
                    return saved;
                });

        mockMvc.perform(post("/api/clientes")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(cliente)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1));
    }

    @Test
    void actualizarCliente_existente() throws Exception {
        Clientes existente = new Clientes(1L, "Pedro", "pedro@mail.com", "555", "Calle A", LocalDate.now());
        Clientes actualizado = new Clientes(null, "Pedro Nuevo", "nuevo@mail.com", "000", "Calle B", LocalDate.now());

        when(clientesRepository.findById(1L)).thenReturn(Optional.of(existente));
        when(clientesRepository.save(any(Clientes.class))).thenReturn(actualizado);

        mockMvc.perform(put("/api/clientes/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(actualizado)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nombre").value("Pedro Nuevo"));
    }

    @Test
    void eliminarCliente_existente() throws Exception {
        when(clientesRepository.existsById(1L)).thenReturn(true);

        mockMvc.perform(delete("/api/clientes/1"))
                .andExpect(status().isNoContent());
    }

    @Test
    void eliminarCliente_noExistente() throws Exception {
        when(clientesRepository.existsById(1L)).thenReturn(false);

        mockMvc.perform(delete("/api/clientes/1"))
                .andExpect(status().isNotFound());
    }
}
