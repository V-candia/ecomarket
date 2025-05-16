package com.ecomarket.ecomarket.service;

import com.ecomarket.ecomarket.model.Clientes;
import com.ecomarket.ecomarket.repository.ClientesRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ClientesService {

    @Autowired
    private ClientesRepository clientesRepository;

    public List<Clientes> obtenerTodos() {
        return clientesRepository.findAll();
    }

    public Clientes guardarCliente(Clientes cliente) {
        return clientesRepository.save(cliente);
    }

    public Optional<Clientes> buscarPorId(int id) {
        return clientesRepository.findById(id);
    }

    public void eliminarCliente(int id) {
        clientesRepository.deleteById(id);
    }
}
