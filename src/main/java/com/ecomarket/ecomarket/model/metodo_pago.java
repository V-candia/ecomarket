package com.ecomarket.ecomarket.model;

import java.util.Date;

public class metodo_pago {
    private int idOrden;
    private String estadoPago;
    private Date fechaPago;
    private String tipoPago;

    // Constructor
    public metodo_pago(int idOrden, String estadoPago, Date fechaPago, String tipoPago) {
        this.idOrden = idOrden;
        this.estadoPago = estadoPago;
        this.fechaPago = fechaPago;
        this.tipoPago = tipoPago;
    }

    // Getters y Setters
    public int getIdOrden() { return idOrden; }
    public void setIdOrden(int idOrden) { this.idOrden = idOrden; }

    public String getEstadoPago() { return estadoPago; }
    public void setEstadoPago(String estadoPago) { this.estadoPago = estadoPago; }

    public Date getFechaPago() { return fechaPago; }
    public void setFechaPago(Date fechaPago) { this.fechaPago = fechaPago; }

    public String getTipoPago() { return tipoPago; }
    public void setTipoPago(String tipoPago) { this.tipoPago = tipoPago; }
}
