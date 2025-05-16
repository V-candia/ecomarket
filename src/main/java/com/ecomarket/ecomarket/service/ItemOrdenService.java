package com.ecomarket.ecomarket.service;

import com.ecomarket.ecomarket.model.ItemOrden;
import com.ecomarket.ecomarket.repository.ItemOrdenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemOrdenService {

    @Autowired
    private ItemOrdenRepository itemOrdenRepository;

    public ItemOrden guardarItemOrden(ItemOrden itemOrden) {
        return itemOrdenRepository.save(itemOrden);
    }

    public Optional<ItemOrden> obtenerItemOrdenPorId(Long id) {
        return itemOrdenRepository.findById(id);
    }

    public List<ItemOrden> obtenerTodosLosItemOrdenes() {
        return itemOrdenRepository.findAll();
    }

    public ItemOrden actualizarItemOrden(Long id, ItemOrden itemOrden) {
        Optional<ItemOrden> itemExistente = itemOrdenRepository.findById(id);
        if (itemExistente.isPresent()) {
            ItemOrden actualizado = itemExistente.get();
            actualizado.setProducto(itemOrden.getProducto());
            actualizado.setCantidadSolicitada(itemOrden.getCantidadSolicitada());
            actualizado.setCantidadEntregada(itemOrden.getCantidadEntregada());
            return itemOrdenRepository.save(actualizado);
        } else {
            return null;
        }
    }

    public void eliminarItemOrden(Long id) {
        itemOrdenRepository.deleteById(id);
    }
}
