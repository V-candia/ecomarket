package com.ecomarket.ecomarket.model;

public class ItemOrden {
    private Productos producto;
    private int cantidadSolicitada;
    private int cantidadEntregada;

    public ItemOrden() {
    }

    public ItemOrden(Productos producto, int cantidadSolicitada, int cantidadEntregada) {
        this.producto = producto;
        this.cantidadSolicitada = cantidadSolicitada;
        this.cantidadEntregada = cantidadEntregada;
    }

    public Productos getProducto() {
        return producto;
    }

    public void setProducto(Productos producto) {
        this.producto = producto;
    }

    public int getCantidadSolicitada() {
        return cantidadSolicitada;
    }

    public void setCantidadSolicitada(int cantidadSolicitada) {
        this.cantidadSolicitada = cantidadSolicitada;
    }

    public int getCantidadEntregada() {
        return cantidadEntregada;
    }

    public void setCantidadEntregada(int cantidadEntregada) {
        this.cantidadEntregada = cantidadEntregada;
    }

    public int calcularDiferencia() {
        return cantidadSolicitada - cantidadEntregada;
    }

    @Override
    public String toString() {
        return "ItemOrden{" +
                "producto=" + producto +
                ", cantidadSolicitada=" + cantidadSolicitada +
                ", cantidadEntregada=" + cantidadEntregada +
                '}';
    }
}
