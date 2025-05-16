package com.ecomarket.ecomarket.model;

import java.time.LocalDate;

public class carrito_compras {
    private int ID_carrito;
    private int ID_cliente;
    private LocalDate fecha_creacion;

    // Constructor vacío
    public carrito_compras() {
    }

    // Constructor con todos los campos
    public carrito_compras(int ID_carrito, int ID_cliente, LocalDate fecha_creacion) {
        this.ID_carrito = ID_carrito;
        this.ID_cliente = ID_cliente;
        this.fecha_creacion = fecha_creacion;
    }

    // Getters y Setters
    public int getID_carrito() {
        return ID_carrito;
    }

    public void setID_carrito(int ID_carrito) {
        this.ID_carrito = ID_carrito;
    }

    public int getID_cliente() {
        return ID_cliente;
    }

    public void setID_cliente(int ID_cliente) {
        this.ID_cliente = ID_cliente;
    }

    public LocalDate getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(LocalDate fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

    @Override
    public String toString() {
        return "carrito_compras{" +
                "ID_carrito=" + ID_carrito +
                ", ID_cliente=" + ID_cliente +
                ", fecha_creacion=" + fecha_creacion +
                '}';
    }
}
