package com.ecomarket.ecomarket.model;

public class categorias {
    private int ID_categoria;
    private String nombre_categoria;
    private String descripcion;

    // Constructor vacío
    public categorias() {
    }

    // Constructor con todos los campos
    public categorias(int ID_categoria, String nombre_categoria, String descripcion) {
        this.ID_categoria = ID_categoria;
        this.nombre_categoria = nombre_categoria;
        this.descripcion = descripcion;
    }

    // Getters y Setters
    public int getID_categoria() {
        return ID_categoria;
    }

    public void setID_categoria(int ID_categoria) {
        this.ID_categoria = ID_categoria;
    }

    public String getNombre_categoria() {
        return nombre_categoria;
    }

    public void setNombre_categoria(String nombre_categoria) {
        this.nombre_categoria = nombre_categoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "categorias{" +
                "ID_categoria=" + ID_categoria +
                ", nombre_categoria='" + nombre_categoria + '\'' +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}
