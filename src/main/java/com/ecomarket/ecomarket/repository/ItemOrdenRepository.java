package com.ecomarket.ecomarket.repository;

import com.ecomarket.ecomarket.model.ItemOrden;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ItemOrdenRepository extends JpaRepository<ItemOrden, Long> {
}
