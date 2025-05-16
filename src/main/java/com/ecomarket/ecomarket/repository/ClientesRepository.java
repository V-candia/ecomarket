package com.ecomarket.ecomarket.repository;

import com.ecomarket.ecomarket.model.Clientes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientesRepository extends JpaRepository<Clientes, Integer> {


    Clientes findByCorreoElectronico(String correo_electronico);

    boolean existsByCorreoElectronico(String correo_electronico);
}
