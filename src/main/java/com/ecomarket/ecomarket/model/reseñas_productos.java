package com.ecomarket.ecomarket.model;

import java.time.LocalDate;

public class reseñas_productos {
    private int id_reseña;
    private int id_cliente;
    private int id_producto;
    private int calificacion;
    private String comentario;
    private LocalDate fecha;

    // Constructor vacío
    public reseñas_productos() {
    }

    // Constructor con todos los campos
    public reseñas_productos(int id_reseña, int id_cliente, int id_producto, int calificacion, String comentario, LocalDate fecha) {
        this.id_reseña = id_reseña;
        this.id_cliente = id_cliente;
        this.id_producto = id_producto;
        this.calificacion = calificacion;
        this.comentario = comentario;
        this.fecha = fecha;
    }

    // Getters y Setters
    public int getId_reseña() {
        return id_reseña;
    }

    public void setId_reseña(int id_reseña) {
        this.id_reseña = id_reseña;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "reseñas_productos{" +
                "id_reseña=" + id_reseña +
                ", id_cliente=" + id_cliente +
                ", id_producto=" + id_producto +
                ", calificacion=" + calificacion +
                ", comentario='" + comentario + '\'' +
                ", fecha=" + fecha +
                '}';
    }
}
