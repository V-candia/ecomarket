package com.ecomarket.ecomarket.model;
import com.ecomarket.ecomarket.model.ItemOrden;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;

public class OrdenReposicion {
    private String idOrden;
    private Date fechaGeneracion;
    private String estado; // Ej: "pendiente", "en proceso", "enviada", "entregada"
    private String tipo;   // Ej: "automatica" o "manual"
    private List<ItemOrden> items;

    // Constructor
    public OrdenReposicion(String idOrden, Date fechaGeneracion, String estado, String tipo) {
        this.idOrden = idOrden;
        this.fechaGeneracion = fechaGeneracion;
        this.estado = estado;
        this.tipo = tipo;
        this.items = new ArrayList<>();
    }

    // Getters y Setters
    public String getIdOrden() {
        return idOrden;
    }

    public void setIdOrden(String idOrden) {
        this.idOrden = idOrden;
    }

    public Date getFechaGeneracion() {
        return fechaGeneracion;
    }

    public void setFechaGeneracion(Date fechaGeneracion) {
        this.fechaGeneracion = fechaGeneracion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public List<ItemOrden> getItems() {
        return items;
    }

    // Métodos de negocio

    public void agregarItem(ItemOrden item) {
        items.add(item);
    }

    public int calcularTotalProductos() {
        int total = 0;
        for (ItemOrden item : items) {
            total += item.getCantidadSolicitada();
        }
        return total;
    }

    public void cambiarEstado(String nuevoEstado) {
        this.estado = nuevoEstado;
    }

    @Override
    public String toString() {
        return "OrdenReposicion{" +
                "idOrden='" + idOrden + '\'' +
                ", fechaGeneracion=" + fechaGeneracion +
                ", estado='" + estado + '\'' +
                ", tipo='" + tipo + '\'' +
                ", totalItems=" + items.size() +
                '}';
    }
}
