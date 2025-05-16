package com.ecomarket.ecomarket.service;

import com.ecomarket.ecomarket.model.OrdenReposicion;
import com.ecomarket.ecomarket.repository.OrdenReposicionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrdenReposicionService {

    @Autowired
    private OrdenReposicionRepository ordenReposicionRepository;

    public OrdenReposicion guardarOrden(OrdenReposicion orden) {
        return ordenReposicionRepository.save(orden);
    }

    public Optional<OrdenReposicion> obtenerPorId(String id) {
        return ordenReposicionRepository.findById(id);
    }

    public List<OrdenReposicion> listarTodas() {
        return ordenReposicionRepository.findAll();
    }

    public OrdenReposicion actualizarOrden(String id, OrdenReposicion ordenActualizada) {
        return ordenReposicionRepository.findById(id).map(orden -> {
            orden.setEstado(ordenActualizada.getEstado());
            orden.setFechaGeneracion(ordenActualizada.getFechaGeneracion());
            orden.setTipo(ordenActualizada.getTipo());
            orden.getItems().clear();
            orden.getItems().addAll(ordenActualizada.getItems());
            return ordenReposicionRepository.save(orden);
        }).orElse(null);
    }

    public void eliminarOrden(String id) {
        ordenReposicionRepository.deleteById(id);
    }
}
