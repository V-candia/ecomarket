package com.ecomarket.ecomarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecomarket.ecomarket.model.Clientes;

@Repository
public interface ClientesRepository extends JpaRepository<Clientes, Long> {
    boolean existsByCorreoElectronico(String correoElectronico);
}