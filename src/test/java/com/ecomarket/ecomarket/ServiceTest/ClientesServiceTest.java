package com.ecomarket.ecomarket.ServiceTest;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import com.ecomarket.ecomarket.model.Clientes;
import com.ecomarket.ecomarket.repository.ClientesRepository;
import com.ecomarket.ecomarket.service.ClientesService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@SpringBootTest
public class ClientesServiceTest {

    @Autowired
    private ClientesService clientesService;

    @MockBean
    private ClientesRepository clientesRepository;

    @Test
    public void testFindAll() {
        Clientes cliente = new Clientes(1L, "Juan", "Pérez", "juan.perez@example.com", "12345678-9", LocalDate.now());
        when(clientesRepository.findAll()).thenReturn(List.of(cliente));

        List<Clientes> clientes = clientesService.obtenerTodos();
        assertNotNull(clientes);
        assertEquals(1, clientes.size());
        assertEquals("Juan", clientes.get(0).getNombre());
    }

    @Test
    public void testFindById() {
        Long id = 1L;
        Clientes cliente = new Clientes(id, "Juan", "Pérez", "juan.perez@example.com", "12345678-9", LocalDate.now());
        when(clientesRepository.findById(id)).thenReturn(Optional.of(cliente));

        Optional<Clientes> foundOptional = clientesService.buscarPorId(id);
        assertTrue(foundOptional.isPresent());

        Clientes found = foundOptional.get();
        assertNotNull(found);
        assertEquals(id, found.getId());
        assertEquals("Juan", found.getNombre());
    }


    @Test
    public void testSave() {
        Clientes cliente = new Clientes(1L, "Juan", "Pérez", "juan.perez@example.com", "12345678-9", LocalDate.now());
        when(clientesRepository.save(cliente)).thenReturn(cliente);

        Clientes saved = clientesService.guardarCliente(cliente);
        assertNotNull(saved);
        assertEquals("Juan", saved.getNombre());
    }

    @Test
    public void testDeleteById() {
        Long id = 1L;
        doNothing().when(clientesRepository).deleteById(id);

        clientesService.eliminarCliente(id);
        verify(clientesRepository, times(1)).deleteById(id);
    }
}
