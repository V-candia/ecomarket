package com.ecomarket.ecomarket.model;

import java.time.LocalDate;

public class ordenes {
    private int id_orden;
    private int id_cliente;
    private String estado_orden;
    private LocalDate fecha_orden;
    private double total;

    // Constructor vacío
    public ordenes() {
    }

    // Constructor con todos los campos
    public ordenes(int id_orden, int id_cliente, String estado_orden, LocalDate fecha_orden, double total) {
        this.id_orden = id_orden;
        this.id_cliente = id_cliente;
        this.estado_orden = estado_orden;
        this.fecha_orden = fecha_orden;
        this.total = total;
    }

    // Getters y Setters
    public int getId_orden() {
        return id_orden;
    }

    public void setId_orden(int id_orden) {
        this.id_orden = id_orden;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getEstado_orden() {
        return estado_orden;
    }

    public void setEstado_orden(String estado_orden) {
        this.estado_orden = estado_orden;
    }

    public LocalDate getFecha_orden() {
        return fecha_orden;
    }

    public void setFecha_orden(LocalDate fecha_orden) {
        this.fecha_orden = fecha_orden;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "ordenes{" +
                "id_orden=" + id_orden +
                ", id_cliente=" + id_cliente +
                ", estado_orden='" + estado_orden + '\'' +
                ", fecha_orden=" + fecha_orden +
                ", total=" + total +
                '}';
    }
}
