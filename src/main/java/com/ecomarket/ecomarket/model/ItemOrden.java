package com.ecomarket.ecomarket.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "item_orden")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemOrden {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_producto", nullable = false)
    private Productos producto;

    @Column(nullable = false)
    private int cantidadSolicitada;

    @Column(nullable = false)
    private int cantidadEntregada;

    public int calcularDiferencia() {
        return cantidadSolicitada - cantidadEntregada;
    }
}
