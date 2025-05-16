package com.ecomarket.ecomarket.model;

import java.time.LocalDateTime;

public class usuarios {
    private int id_usuario;
    private String nombre_usuario;
    private String contraseña_hash;
    private LocalDateTime fecha_creacion;
    private String rol;

    // Constructor vacío
    public usuarios() {
    }

    // Constructor con todos los campos
    public usuarios(int id_usuario, String nombre_usuario, String contraseña_hash, LocalDateTime fecha_creacion, String rol) {
        this.id_usuario = id_usuario;
        this.nombre_usuario = nombre_usuario;
        this.contraseña_hash = contraseña_hash;
        this.fecha_creacion = fecha_creacion;
        this.rol = rol;
    }

    // Getters y Setters
    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public String getContraseña_hash() {
        return contraseña_hash;
    }

    public void setContraseña_hash(String contraseña_hash) {
        this.contraseña_hash = contraseña_hash;
    }

    public LocalDateTime getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(LocalDateTime fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    @Override
    public String toString() {
        return "usuarios{" +
                "id_usuario=" + id_usuario +
                ", nombre_usuario='" + nombre_usuario + '\'' +
                ", contraseña_hash='" + contraseña_hash + '\'' +
                ", fecha_creacion=" + fecha_creacion +
                ", rol='" + rol + '\'' +
                '}';
    }
}
