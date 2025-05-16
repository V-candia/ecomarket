package com.ecomarket.ecomarket.repository;
import com.ecomarket.ecomarket.model.OrdenReposicion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdenReposicionRepository extends JpaRepository<OrdenReposicion, String> {
}
