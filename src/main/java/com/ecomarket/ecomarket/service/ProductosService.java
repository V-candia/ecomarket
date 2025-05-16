package com.ecomarket.ecomarket.service;

import com.ecomarket.ecomarket.model.Productos;
import com.ecomarket.ecomarket.repository.ProductosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductosService {

    @Autowired
    private ProductosRepository productosRepository;

    public List<Productos> obtenerTodos() {
        return productosRepository.findAll();
    }

    public Optional<Productos> obtenerPorId(int id) {
        return productosRepository.findById(id);
    }

    public Productos guardar(Productos producto) {
        return productosRepository.save(producto);
    }

    public void eliminar(int id) {
        productosRepository.deleteById(id);
    }

    public boolean existePorSku(String sku) {
        return productosRepository.existsBySku(sku);
    }
}
