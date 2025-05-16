package com.ecomarket.ecomarket.model;

import java.time.LocalDate;

public class envios {
    private int id_envio;
    private int id_orden;
    private String direccion_envio;
    private String empresa_envio;
    private String estado_envio;
    private LocalDate fecha_envio;
    private String numero_guia;

    // Constructor vacío
    public envios() {
    }

    // Constructor con todos los campos
    public envios(int id_envio, int id_orden, String direccion_envio, String empresa_envio, String estado_envio, LocalDate fecha_envio, String numero_guia) {
        this.id_envio = id_envio;
        this.id_orden = id_orden;
        this.direccion_envio = direccion_envio;
        this.empresa_envio = empresa_envio;
        this.estado_envio = estado_envio;
        this.fecha_envio = fecha_envio;
        this.numero_guia = numero_guia;
    }

    // Getters y Setters
    public int getId_envio() {
        return id_envio;
    }

    public void setId_envio(int id_envio) {
        this.id_envio = id_envio;
    }

    public int getId_orden() {
        return id_orden;
    }

    public void setId_orden(int id_orden) {
        this.id_orden = id_orden;
    }

    public String getDireccion_envio() {
        return direccion_envio;
    }

    public void setDireccion_envio(String direccion_envio) {
        this.direccion_envio = direccion_envio;
    }

    public String getEmpresa_envio() {
        return empresa_envio;
    }

    public void setEmpresa_envio(String empresa_envio) {
        this.empresa_envio = empresa_envio;
    }

    public String getEstado_envio() {
        return estado_envio;
    }

    public void setEstado_envio(String estado_envio) {
        this.estado_envio = estado_envio;
    }

    public LocalDate getFecha_envio() {
        return fecha_envio;
    }

    public void setFecha_envio(LocalDate fecha_envio) {
        this.fecha_envio = fecha_envio;
    }

    public String getNumero_guia() {
        return numero_guia;
    }

    public void setNumero_guia(String numero_guia) {
        this.numero_guia = numero_guia;
    }

    @Override
    public String toString() {
        return "envios{" +
                "id_envio=" + id_envio +
                ", id_orden=" + id_orden +
                ", direccion_envio='" + direccion_envio + '\'' +
                ", empresa_envio='" + empresa_envio + '\'' +
                ", estado_envio='" + estado_envio + '\'' +
                ", fecha_envio=" + fecha_envio +
                ", numero_guia='" + numero_guia + '\'' +
                '}';
    }
}
