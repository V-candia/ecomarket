package com.ecomarket.ecomarket.repository;

import com.ecomarket.ecomarket.model.Productos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductosRepository extends JpaRepository<Productos, Integer> {
    Productos findBySku(String sku);
    boolean existsBySku(String sku);
}
