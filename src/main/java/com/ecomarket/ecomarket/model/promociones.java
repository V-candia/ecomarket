package com.ecomarket.ecomarket.model;

import java.time.LocalDate;

public class promociones {
    private int id_promocion;
    private String codigo;
    private String descripcion;
    private LocalDate fecha_inicio;
    private LocalDate fecha_fin;
    private double porcentaje_descuento;

    // Constructor vacío
    public promociones() {
    }

    // Constructor con todos los campos
    public promociones(int id_promocion, String codigo, String descripcion, LocalDate fecha_inicio, LocalDate fecha_fin, double porcentaje_descuento) {
        this.id_promocion = id_promocion;
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
        this.porcentaje_descuento = porcentaje_descuento;
    }

    // Getters y Setters
    public int getId_promocion() {
        return id_promocion;
    }

    public void setId_promocion(int id_promocion) {
        this.id_promocion = id_promocion;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDate getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(LocalDate fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public LocalDate getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(LocalDate fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    public double getPorcentaje_descuento() {
        return porcentaje_descuento;
    }

    public void setPorcentaje_descuento(double porcentaje_descuento) {
        this.porcentaje_descuento = porcentaje_descuento;
    }

    @Override
    public String toString() {
        return "promociones{" +
                "id_promocion=" + id_promocion +
                ", codigo='" + codigo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", fecha_inicio=" + fecha_inicio +
                ", fecha_fin=" + fecha_fin +
                ", porcentaje_descuento=" + porcentaje_descuento +
                '}';
    }
}
