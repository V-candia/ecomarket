package com.ecomarket.ecomarket.model;

import java.time.LocalDate;

public class Clientes {
    private int ID_cliente;
    private String nombre;
    private String correo_electronico;
    private String telefono;
    private String direccion;
    private LocalDate fecha_registro;

    // Constructor vacío
    public Clientes() {
    }

    // Constructor con todos los campos
    public Clientes(int ID_cliente, String nombre, String correo_electronico,
                    String telefono, String direccion, LocalDate fecha_registro) {
        this.ID_cliente = ID_cliente;
        this.nombre = nombre;
        this.correo_electronico = correo_electronico;
        this.telefono = telefono;
        this.direccion = direccion;
        this.fecha_registro = fecha_registro;
    }

    // Getters y Setters
    public int getID_cliente() {
        return ID_cliente;
    }

    public void setID_cliente(int ID_cliente) {
        this.ID_cliente = ID_cliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo_electronico() {
        return correo_electronico;
    }

    public void setCorreo_electronico(String correo_electronico) {
        this.correo_electronico = correo_electronico;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public LocalDate getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(LocalDate fecha_registro) {
        this.fecha_registro = fecha_registro;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "ID_cliente=" + ID_cliente +
                ", nombre='" + nombre + '\'' +
                ", correo_electronico='" + correo_electronico + '\'' +
                ", telefono='" + telefono + '\'' +
                ", direccion='" + direccion + '\'' +
                ", fecha_registro=" + fecha_registro +
                '}';
    }
}
