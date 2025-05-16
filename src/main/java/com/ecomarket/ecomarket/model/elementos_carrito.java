package com.ecomarket.ecomarket.model;

import java.util.Objects;

public class elementos_carrito {
    private int idElemento;
    private int idCarrito;
    private int idProducto;

    // Constructor
    public elementos_carrito(int idElemento, int idCarrito, int idProducto) {
        this.idElemento = idElemento;
        this.idCarrito = idCarrito;
        this.idProducto = idProducto;
    }

    // Getters y Setters
    public int getIdElemento() { return idElemento; }
    public void setIdElemento(int idElemento) { this.idElemento = idElemento; }

    public int getIdCarrito() { return idCarrito; }
    public void setIdCarrito(int idCarrito) { this.idCarrito = idCarrito; }

    public int getIdProducto() { return idProducto; }
    public void setIdProducto(int idProducto) { this.idProducto = idProducto; }

    // toString()
    @Override
    public String toString() {
        return "ElementosCarrito{" +
                "idElemento=" + idElemento +
                ", idCarrito=" + idCarrito +
                ", idProducto=" + idProducto +
                '}';
    }

    // equals()
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof elementos_carrito)) return false;
        elementos_carrito that = (elementos_carrito) o;
        return idElemento == that.idElemento &&
                idCarrito == that.idCarrito &&
                idProducto == that.idProducto;
    }

    // hashCode()
    @Override
    public int hashCode() {
        return Objects.hash(idElemento, idCarrito, idProducto);
    }
}
