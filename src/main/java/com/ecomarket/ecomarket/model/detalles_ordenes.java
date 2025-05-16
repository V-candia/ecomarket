package com.ecomarket.ecomarket.model;

public class detalles_ordenes {
    private int id_detalle;
    private int id_orden;
    private int id_producto;
    private int cantidad;
    private double precio_unitario;

    // Constructor vacío
    public detalles_ordenes() {
    }

    // Constructor con todos los campos
    public detalles_ordenes(int id_detalle, int id_orden, int id_producto, int cantidad, double precio_unitario) {
        this.id_detalle = id_detalle;
        this.id_orden = id_orden;
        this.id_producto = id_producto;
        this.cantidad = cantidad;
        this.precio_unitario = precio_unitario;
    }

    // Getters y Setters
    public int getId_detalle() {
        return id_detalle;
    }

    public void setId_detalle(int id_detalle) {
        this.id_detalle = id_detalle;
    }

    public int getId_orden() {
        return id_orden;
    }

    public void setId_orden(int id_orden) {
        this.id_orden = id_orden;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio_unitario() {
        return precio_unitario;
    }

    public void setPrecio_unitario(double precio_unitario) {
        this.precio_unitario = precio_unitario;
    }

    @Override
    public String toString() {
        return "detalles_ordenes{" +
                "id_detalle=" + id_detalle +
                ", id_orden=" + id_orden +
                ", id_producto=" + id_producto +
                ", cantidad=" + cantidad +
                ", precio_unitario=" + precio_unitario +
                '}';
    }
}
