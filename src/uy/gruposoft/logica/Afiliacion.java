/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.gruposoft.logica;

import java.util.Date;

/**
 *
 * @author Administrador
 */
public class Afiliacion {
    private int id;
    private int cedula;
    private int monto;
    private Date fechaDePago;

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }

    public Date getFechaDePago() {
        return fechaDePago;
    }

    public void setFechaDePago(Date fechaDePago) {
        this.fechaDePago = fechaDePago;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
