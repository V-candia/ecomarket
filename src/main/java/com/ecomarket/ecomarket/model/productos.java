package com.ecomarket.ecomarket.model;

public class productos {
    private int id_producto;
    private int id_categoria;
    private String nombre;
    private String descripcion;
    private String sku;
    private String imagen;
    private double precio;
    private int stock;

    // Constructor vacío
    public productos() {
    }

    // Constructor con todos los campos
    public productos(int id_producto, int id_categoria, String nombre, String descripcion, String sku, String imagen, double precio, int stock) {
        this.id_producto = id_producto;
        this.id_categoria = id_categoria;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.sku = sku;
        this.imagen = imagen;
        this.precio = precio;
        this.stock = stock;
    }

    // Getters y Setters
    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public int getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "productos{" +
                "id_producto=" + id_producto +
                ", id_categoria=" + id_categoria +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", sku='" + sku + '\'' +
                ", imagen='" + imagen + '\'' +
                ", precio=" + precio +
                ", stock=" + stock +
                '}';
    }
}
