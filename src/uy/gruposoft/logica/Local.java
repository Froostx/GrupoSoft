/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.gruposoft.logica;

import java.util.Date;

/**
 *
 * @author andressantucci
 */
public class Local {
    private int numeroLocal;
    private Negocio negocio;
    private Date fechaAlta;
    private Date fechaBaja;
    private String encargado;

    public void setNumeroLocal(int numeroLocal) {
        this.numeroLocal = numeroLocal;
    }

    public void setNegocio(Negocio negocio) {
        this.negocio = negocio;
    }

    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public void setFechaBaja(Date fechaBaja) {
        this.fechaBaja = fechaBaja;
    }
    
    public void setEncargado(String encargado){
        this.encargado = encargado;
    }
    
    public int getNumeroLocal() {
        return numeroLocal;
    }

    public Negocio getNegocio() {
        return negocio;
    }

    public Date getFechaAlta() {
        return fechaAlta;
    }

    public Date getFechaBaja() {
        return fechaBaja;
    }

    public String getEncargado() {
        return encargado;
    }
     
}


