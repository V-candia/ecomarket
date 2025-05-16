package com.ecomarket.ecomarket.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "orden_reposicion")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrdenReposicion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idOrden;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date fechaGeneracion;

    @Column(nullable = false)
    private String estado;

    @Column(nullable = false)
    private String tipo;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "orden_id")
    private List<ItemOrden> items;

    // Método de negocio (no se ve afectado por Lombok)
    public int calcularTotalProductos() {
        return items.stream().mapToInt(ItemOrden::getCantidadSolicitada).sum();
    }
}
